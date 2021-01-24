package com.ruoyi.project.system.room.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.room.domain.ChatRoom;
import com.ruoyi.project.system.room.service.IChatRoomService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 微信群管理Controller
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Controller
@RequestMapping("/system/room")
public class ChatRoomController extends BaseController
{
    private String prefix = "system/room";

    @Autowired
    private IChatRoomService chatRoomService;

    @RequiresPermissions("system:room:view")
    @GetMapping()
    public String room()
    {
        return prefix + "/room";
    }

    /**
     * 查询微信群管理列表
     */
    @RequiresPermissions("system:room:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ChatRoom chatRoom)
    {
        startPage();
        List<ChatRoom> list = chatRoomService.selectChatRoomList(chatRoom);
        return getDataTable(list);
    }

    /**
     * 导出微信群管理列表
     */
    @RequiresPermissions("system:room:export")
    @Log(title = "微信群管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ChatRoom chatRoom)
    {
        List<ChatRoom> list = chatRoomService.selectChatRoomList(chatRoom);
        ExcelUtil<ChatRoom> util = new ExcelUtil<ChatRoom>(ChatRoom.class);
        return util.exportExcel(list, "room");
    }

    /**
     * 新增微信群管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存微信群管理
     */
    @RequiresPermissions("system:room:add")
    @Log(title = "微信群管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ChatRoom chatRoom)
    {
        return toAjax(chatRoomService.insertChatRoom(chatRoom));
    }

    /**
     * 修改微信群管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ChatRoom chatRoom = chatRoomService.selectChatRoomById(id);
        mmap.put("chatRoom", chatRoom);
        return prefix + "/edit";
    }

    /**
     * 修改保存微信群管理
     */
    @RequiresPermissions("system:room:edit")
    @Log(title = "微信群管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ChatRoom chatRoom)
    {
        return toAjax(chatRoomService.updateChatRoom(chatRoom));
    }

    /**
     * 删除微信群管理
     */
    @RequiresPermissions("system:room:remove")
    @Log(title = "微信群管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(chatRoomService.deleteChatRoomByIds(ids));
    }
}
