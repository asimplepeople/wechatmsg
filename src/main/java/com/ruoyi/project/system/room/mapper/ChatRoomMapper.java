package com.ruoyi.project.system.room.mapper;

import java.util.List;
import com.ruoyi.project.system.room.domain.ChatRoom;
import com.ruoyi.project.system.room.domain.ChatRoomUserRele;

/**
 * 微信群管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface ChatRoomMapper 
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
     * 删除微信群管理
     * 
     * @param id 微信群管理ID
     * @return 结果
     */
    public int deleteChatRoomById(Long id);

    /**
     * 批量删除微信群管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteChatRoomByIds(String[] ids);

    /**
     * 批量删除${subTable.functionName}
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteChatRoomUserReleByChatRoomIds(String[] ids);
    
    /**
     * 批量新增${subTable.functionName}
     * 
     * @param chatRoomUserReleList ${subTable.functionName}列表
     * @return 结果
     */
    public int batchChatRoomUserRele(List<ChatRoomUserRele> chatRoomUserReleList);
    

    /**
     * 通过微信群管理ID删除${subTable.functionName}信息
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteChatRoomUserReleByChatRoomId(Long id);
}
