package com.wen.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class htmlParse {
    public static JSONArray toJson(String htmltest) {
        String html = htmltest;
        Document doc = Jsoup.parse(html);
        Elements rows = doc.select("li[class=query-salary__uls__li]");
        JSONArray arrays = new JSONArray();
        JSONObject json = null;
        JSONArray children = null;
        children = new JSONArray();
        for (Element el : rows) {
            json = new JSONObject();
            json.put("value", "");
            json.put("name", el.text());
            children.add(json);
        }
        return children;

    }

    public static void main(String[] args) {

        String html = "<div class=\"query_salary_box query-salary\">\r\n"
                      + "  <a href=\"?jl=749&amp;in=160400&amp;sf=0&amp;st=0\" class=\"query-salary__all\">不限</a>\r\n"
                      + "  <ul class=\"query-salary__uls\">\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=1&amp;st=1000\" class=\"zp-query\">1K以下</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=1001&amp;st=2000\" class=\"zp-query\">1K-2K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=2001&amp;st=4000\" class=\"zp-query\">2K-4K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=4001&amp;st=6000\" class=\"zp-query\">4K-6K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=6001&amp;st=8000\" class=\"zp-query\">6K-8K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=8001&amp;st=10000\" class=\"zp-query\">8K-10K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=10001&amp;st=15000\" class=\"zp-query\">10K-15K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=15001&amp;st=25000\" class=\"zp-query\">15K-25K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=25001&amp;st=35000\" class=\"zp-query\">25K-35K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=35001&amp;st=50000\" class=\"zp-query\">35K-50K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=50001&amp;st=70000\" class=\"zp-query\">50K-70K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=70001&amp;st=100000\" class=\"zp-query\">70K-100K</a></li>\r\n"
                      + "    <li class=\"query-salary__uls__li\">\r\n"
                      + "      <a href=\"?jl=749&amp;in=160400&amp;sf=100001&amp;st=999999\" class=\"zp-query\">100K以上</a></li>\r\n"
                      + "  </ul>\r\n" + "</div>";
        JSONArray json = toJson(html);
        System.err.println(json);
    }
}
