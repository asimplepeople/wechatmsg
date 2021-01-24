package com.ruoyi.project.system.room.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.system.room.domain.ChatRoomUserRele;
import com.ruoyi.project.system.room.mapper.ChatRoomMapper;
import com.ruoyi.project.system.room.domain.ChatRoom;
import com.ruoyi.project.system.room.service.IChatRoomService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 微信群管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Service
public class ChatRoomServiceImpl implements IChatRoomService 
{
    @Autowired
    private ChatRoomMapper chatRoomMapper;

    /**
     * 查询微信群管理
     * 
     * @param id 微信群管理ID
     * @return 微信群管理
     */
    @Override
    public ChatRoom selectChatRoomById(Long id)
    {
        return chatRoomMapper.selectChatRoomById(id);
    }

    /**
     * 查询微信群管理列表
     * 
     * @param chatRoom 微信群管理
     * @return 微信群管理
     */
    @Override
    public List<ChatRoom> selectChatRoomList(ChatRoom chatRoom)
    {
        return chatRoomMapper.selectChatRoomList(chatRoom);
    }

    /**
     * 新增微信群管理
     * 
     * @param chatRoom 微信群管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertChatRoom(ChatRoom chatRoom)
    {
        int rows = chatRoomMapper.insertChatRoom(chatRoom);
        insertChatRoomUserRele(chatRoom);
        return rows;
    }

    /**
     * 修改微信群管理
     * 
     * @param chatRoom 微信群管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateChatRoom(ChatRoom chatRoom)
    {
        chatRoomMapper.deleteChatRoomUserReleByChatRoomId(chatRoom.getId());
        insertChatRoomUserRele(chatRoom);
        return chatRoomMapper.updateChatRoom(chatRoom);
    }

    /**
     * 删除微信群管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteChatRoomByIds(String ids)
    {
        chatRoomMapper.deleteChatRoomUserReleByChatRoomIds(Convert.toStrArray(ids));
        return chatRoomMapper.deleteChatRoomByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除微信群管理信息
     * 
     * @param id 微信群管理ID
     * @return 结果
     */
    @Override
    public int deleteChatRoomById(Long id)
    {
        chatRoomMapper.deleteChatRoomUserReleByChatRoomId(id);
        return chatRoomMapper.deleteChatRoomById(id);
    }

    /**
     * 新增${subTable.functionName}信息
     * 
     * @param chatRoom 微信群管理对象
     */
    public void insertChatRoomUserRele(ChatRoom chatRoom)
    {
        List<ChatRoomUserRele> chatRoomUserReleList = chatRoom.getChatRoomUserReleList();
        Long id = chatRoom.getId();
        if (StringUtils.isNotNull(chatRoomUserReleList))
        {
            List<ChatRoomUserRele> list = new ArrayList<ChatRoomUserRele>();
            for (ChatRoomUserRele chatRoomUserRele : chatRoomUserReleList)
            {
                chatRoomUserRele.setChatRoomId(id);
                list.add(chatRoomUserRele);
            }
            if (list.size() > 0)
            {
                chatRoomMapper.batchChatRoomUserRele(list);
            }
        }
    }
}
