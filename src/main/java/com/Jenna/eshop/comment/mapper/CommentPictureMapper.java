package com.Jenna.eshop.comment.mapper;

import com.Jenna.eshop.comment.domain.CommentPictureDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论晒图管理模块的Mapper组件
 * @author Jenna C He
 * @date 2023/1/10 14:49
 */
@Mapper
public interface CommentPictureMapper {
    /**
     * 新增评论晒图
     * @param commentPictureDO 评论晒图的DO对象
     */
    @Insert("INSERT INTO comment_picture("
                +"comment_info_id,"
                +"comment_picture_path,"
                +"gmt_create,"
                +"gmt_modified"
                +")"
                +"VALUES("
                +"#{commentInfoId},"
                +"#{commentPicturePath},"
                +"#{gmtCreate},"
                +"#{gmtModified}"
                +")")
    void saveCommentPicture(CommentPictureDO commentPictureDO);

}
