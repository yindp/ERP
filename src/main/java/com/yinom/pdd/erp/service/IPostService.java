package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.Post;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface IPostService {
    void insert(Post post);
    List<Post> queryAll(Post post);
}
