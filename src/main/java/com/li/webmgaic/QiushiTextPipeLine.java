package com.li.webmgaic;/**
 * @author lihaodong
 * @create 2018-10-11 11:01
 * @desc
 **/

import com.li.model.ArticleVo;
import com.li.utils.JDBCUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author lihaodong
 * @create 2018-10-11 11:01
 * @desc
 **/

public class QiuShiTextPipeLine implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {

        List<String> imgList = resultItems.get("imgList");
        List<String> userNameList = resultItems.get("userNameList");
        List<String> contentList = resultItems.get("contentList");



        for(int i = 0,len = imgList.size();i<len;i++){
            ArticleVo articleVo = new ArticleVo();
            String img = imgList.get(i);
            String userName = userNameList.get(i);
            String content = contentList.get(i);

            articleVo.setImg(img);
            articleVo.setUserName(userName);
            articleVo.setContent(content);
            int id = JDBCUtil.insertArticle(articleVo);
            // 返回主键
            System.out.println(id);
        }

    }
}
