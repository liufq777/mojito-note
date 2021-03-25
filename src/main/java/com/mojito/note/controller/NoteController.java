package com.mojito.note.controller;

import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.common.util.IgnorePropertiesUtils;
import com.mojito.common.util.MarkdownUtils;
import com.mojito.note.helper.PermissionHelper;
import com.mojito.note.pojo.dto.CategoryDto;
import com.mojito.note.pojo.dto.NoteDto;
import com.mojito.note.pojo.dto.NoteListDto;
import com.mojito.note.pojo.entity.NoteDo;
import com.mojito.note.pojo.param.NoteParam;
import com.mojito.note.pojo.request.NoteRequest;
import com.mojito.note.service.CategoryService;
import com.mojito.note.service.NoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liufengqiang
 * @date 2020-12-10 21:42:46
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Resource
    private NoteService noteService;
    @Resource
    private CategoryService categoryService;

    /**
     * 笔记列表
     */
    @GetMapping
    public Response list(@RequestAttribute Long loginId, @RequestParam Long userId, @RequestParam(defaultValue = "0") Integer noteType, String search) {
        NoteParam param = new NoteParam();
        param.setUserId(userId);
        param.setPermissions(PermissionHelper.getPermission(userId, loginId));
        param.setSearch(search);
        param.setNoteType(noteType);
        List<NoteDo> notes = noteService.listByParam(param);
        if (CollectionUtils.isEmpty(notes)) {
            return Response.ok();
        }

        Map<String, List<NoteListDto>> noteMap = new LinkedHashMap<>();
        notes.forEach(o -> {
            List<NoteListDto> noteDos = noteMap.get(o.getCategory());
            if (noteDos == null) {
                noteDos = new ArrayList<>();
            }
            noteDos.add(BaseHelper.r2t(o, NoteListDto.class));
            noteMap.put(o.getCategory(), noteDos);
        });

        List<CategoryDto> dtos = new ArrayList<>();
        noteMap.forEach((k, v) -> dtos.add(new CategoryDto(k, v)));
        return Response.ok(dtos);
    }

    /**
     * 新增/修改笔记
     */
    @PostMapping
    public Response save(@RequestAttribute Long loginId, @Valid @RequestBody NoteRequest request) {
        NoteDo note;
        if (request.getId() == null) {
            note = BaseHelper.r2t(request, NoteDo.class);
            note.setUserId(loginId);
        } else {
            note = noteService.getById(request.getId());
            BeanUtils.copyProperties(request, note, IgnorePropertiesUtils.getNullPropertyNames(request));
        }

        if (request.getId() == null) {
            noteService.save(note);
        } else {
            note.setUpdatedAt(LocalDateTime.now());
            noteService.updateById(note);
        }

        categoryService.updateUpdateAt(note.getCategoryId());
        return Response.ok();
    }

    /**
     * 笔记详情
     */
    @GetMapping("/{id}")
    public Response list(@PathVariable Long id) {
        NoteDo note = noteService.getById(id);
        Assert.notNull(note, "笔记不存在");

        NoteDto dto = BaseHelper.r2t(note, NoteDto.class);
        dto.setContentHtml(MarkdownUtils.markdownToHtmlExtensions(dto.getContent()));
        return Response.ok(dto);
    }

    /**
     * 删除笔记
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        noteService.removeById(id);
        return Response.ok();
    }
}
