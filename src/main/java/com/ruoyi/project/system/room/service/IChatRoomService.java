package com.ruoyi.project.system.room.service;

import java.util.List;
import com.ruoyi.project.system.room.domain.ChatRoom;

/**
 * 微信群管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface IChatRoomService 
{
    /**
     * 查询微信群管理
     * 
     * @param id 微信群管理ID
     * @return 微信群管理
     */
    public ChatRoom selectChatRoomById(Long id);

    /**
     * 查询微信群管理列表
     * 
     * @param chatRoom 微信群管理
     * @return 微信群管理集合
     */
    public List<ChatRoom> selectChatRoomList(ChatRoom chatRoom);

    /**
     * 新增微信群管理
     * 
     * @param chatRoom 微信群管理
     * @return 结果
     */
    public int insertChatRoom(ChatRoom chatRoom);

    /**
     * 修改微信群管理
     * 
     * @param chatRoom 微信群管理
     * @return 结果
     */
    public int updateChatRoom(ChatRoom chatRoom);

    /**
     * 批量删除微信群管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteChatRoomByIds(String ids);

    /**
     * 删除微信群管理信息
     * 
     * @param id 微信群管理ID
     * @return 结果
     */
    public int deleteChatRoomById(Long id);
}
