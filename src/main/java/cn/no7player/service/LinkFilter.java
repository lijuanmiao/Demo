package cn.no7player.service;

/**实现抓取内容过滤的接口
 * Created by lijm on 2017-10-24.
 */
public interface LinkFilter {

    public boolean accept(String url);
}
