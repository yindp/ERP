package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.Post;
import com.yinom.pdd.erp.dao.IPostDAO;
import com.yinom.pdd.erp.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */

@Service(value = "iPostService")
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostDAO iPostDAO;

    public void insert(Post post) {
        iPostDAO.insert(post);
    }

    public List<Post> queryAll(Post post) {
        return iPostDAO.queryAll(Post.class);
    }
}
