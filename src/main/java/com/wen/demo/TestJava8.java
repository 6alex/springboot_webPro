package com.wen.demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJava8 {

    List<Staff> publicList = Arrays.asList(new Staff("小明", 18, new BigDecimal(2000)),
            new Staff("小明1", 33, new BigDecimal(22020)), new Staff("小明2", 44, new BigDecimal(2800)),
            new Staff("小明3", 23, new BigDecimal(2700)), new Staff("小明4", 21, null),
            new Staff("小明5", 10, new BigDecimal(1600)), new Staff("小明6", 56, new BigDecimal(21000)),
            new Staff("小明7", 49, new BigDecimal(12000)));

    @Test
    public void java8() throws Exception {
        List<Staff> asList = Arrays.asList(new Staff("小明", 18, new BigDecimal(2000)),
                new Staff("小明1", 33, new BigDecimal(22020)), new Staff("小明2", 44, new BigDecimal(2800)),
                new Staff("小明3", 23, new BigDecimal(2700)), new Staff("小明4", 21, null),
                new Staff("小明5", 10, new BigDecimal(1600)), new Staff("小明6", 56, new BigDecimal(21000)),
                new Staff("小明7", 49, new BigDecimal(12000)));

        BigDecimal reduce = asList.stream().map(c -> c.getSalary() == null ? BigDecimal.ZERO : c.getSalary())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("求出所有人的工资和" + reduce);
        List<Integer> list = Arrays.asList(3, 41, 23, 65, 12, 77, 33, 1, 4);
        Collections.sort(list);
        System.out.println("顺序" + list);
        Collections.reverse(asList);
        System.out.println("倒序" + asList);
        Collections.shuffle(list);
        System.out.println("混序" + list);

        List<Integer> collect = asList.stream().map(e -> e.getAge()).collect(Collectors.toList());
        System.out.println("年龄集合" + collect);

        List<BigDecimal> collect2 = asList.stream().map(Staff::getSalary).distinct().collect(Collectors.toList());
        System.err.println("去重工资集合" + collect2);

        asList.sort(new Comparator<Staff>() {

            @Override
            public int compare(Staff o1, Staff o2) {

                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("对象集合按年龄排序" + asList);
        Collections.sort(collect);
        System.out.println("年龄排序" + collect);

        List<Integer> collect3 = list.stream().filter(e -> (int) e % 2 == 1).collect(Collectors.toList());
        System.out.println("过滤偶数" + collect3);

        List<Staff> collect4 = asList.stream().filter(e -> e.getAge() > 22).collect(Collectors.toList());
        System.out.println("年龄大于22岁" + collect4);

        List<BigDecimal> list10 = asList.stream().map(s -> s.getSalary() == null ? BigDecimal.ZERO : s.getSalary())
                .collect(Collectors.toList());
        System.out.println("工资集合" + list10);

        /*
         * List<Staff> collect5 =
         * asList.stream().sorted(Comparator.comparing(Staff::getSalary)).collect(
         * Collectors.toList()); System.out.println("对象集合按工资排序"+collect5);
         */

        /*
         * List<Staff> collect6 =
         * collect5.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).
         * collect(Collectors.toList()); System.out.println("对象集合按工资从大到小排序"+collect6);
         */

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(new Random().nextInt(100));
        System.out.println(list1);

    }

    @Test
    public void testName() throws Exception {
        BigInteger i = new BigInteger("0");
        System.out.println(i.equals(BigDecimal.ZERO));// false
    }

    @Test
    public void testName1() throws Exception {
        Staff s1 = new Staff("zz", 10, new BigDecimal(2000), new Date());
        Staff2 s2 = new Staff2();
        s2.setSex(1);
        s2.setName("xx");
        s2.setAge(18);

        BeanUtils.copyProperties(s2, s1);
        System.out.println(s2);
        System.out.println(s1);

        String aString = "sdfsfsfsgfsfsdgsdgsgyjtuiyu";
        String string = aString.replace("s", "f");
        System.out.println(string);

    }

    @Test
    public void testIntStream() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        IntStream.range(1, 100).forEach(list::add);
        System.out.println(list);

        // 统计
        List<Integer> list1 = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        IntSummaryStatistics iss = list1.stream().collect(Collectors.summarizingInt(value -> value));
        System.err.println(list1);
        System.out.println(iss);
    }

    @Test
    public void testUUID() throws Exception {
        String uuidRaw = UUID.randomUUID().toString();
        System.err.println(uuidRaw);
    }

    @Test
    public void testList() throws Exception {
        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 4, 5, 6);
        List<Integer> newlist = new ArrayList<>(asList);
        System.err.println("new" + newlist);
        System.out.println(asList);
        System.err.println(asList.toString());
        HashSet<Integer> hashSet = new HashSet<>(newlist);
        String list = hashSet.toString();
        String substring = list.substring(1, list.length() - 1);
        System.out.println("hha" + substring);
    }

    @Test
    public void testremoveAll() throws Exception {
        // 终其原因是Arrays.asList方法返回的ArrayList是继承自AbstractList同时实现;不能添加和删除
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list3 = new ArrayList<>(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);
        list2.add(3);
        list2.add(4);
        boolean removeAll = list1.removeAll(list2);
        System.out.println("(1)" + removeAll + "---" + list1);
        boolean removeAll1 = list2.removeAll(list1);
        System.err.println("(2)" + removeAll1 + "---" + list2);
        System.out.println(list3);

    }

    @Test
    public void testarray() throws Exception {
        String[] arr = { "1", "2", "3" };
        System.err.println(arr);
        System.err.println(arr.toString());

    }

    @Test
    public void testJson() throws Exception {
        List<BigInteger> dicids = JSONArray.parseArray("[]", BigInteger.class);
        System.err.println(dicids);

        String str = "人";
        String sub = "1";
        if (str.endsWith("位") || str.endsWith("个") || str.endsWith("人")) {
            sub = str.substring(0, str.length() - 1);
            if (null == sub || "".equals(sub)) {
                sub = "1";
            }
        }
        System.err.println("截取" + sub);

    }

    @Test
    public void testGetNumberFromNumber() throws Exception {
        String getNumberFromString = getNumberFromString("");
        System.err.println(getNumberFromString);
    }

    public String getNumberFromString(String str) {
        if (null != str) {
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            String trim = m.replaceAll("").trim();
            if (trim.startsWith("0") || trim.equals("") || trim == null) {
                return "1";
            }
            return trim;
        }
        return "1";

    }

    @Test
    public void tes() throws Exception {
        Integer i = 1;
        int n = 1;
        // System.err.println(i==n);

        /*
         * BigInteger a=new BigInteger("3"); List<BigInteger> asList = Arrays.asList(new
         * BigInteger("2"),new BigInteger("3"),new BigInteger("5")); boolean contains =
         * asList.contains(null); System.out.println(contains==true);
         * System.out.println(contains+"-------------");
         */

        List<String> asList1 = Arrays.asList("123", "234", null);
        boolean contains1 = asList1.contains(null);
        System.out.println(contains1 == true);
        System.out.println(contains1 + "-------------1");
    }

    @Test
    public void multiply() throws Exception {
        double doubleValue = new BigDecimal("10").multiply(null).doubleValue();
        System.err.println(doubleValue);
    }

    private BigDecimal getFeeStandard(String feeStandard) {
        switch (feeStandard) {
        case "1":
            return new BigDecimal("0.0005");
        case "2.00":
            return new BigDecimal("0.001");
        case "3.00":
            return new BigDecimal("0.0015");
        case "4.00":
            return new BigDecimal("0.002");
        case "5.00":
            return new BigDecimal("1");
        default:
            return null;
        }

    }

    @Test
    public void test11() throws Exception {
        BigDecimal y = new BigDecimal("1");
        BigDecimal feeStandard = getFeeStandard(y + "");
        System.err.println(feeStandard + "===============" + y);
    }

    @Test
    public void reduce() throws Exception {
        List<Staff> asList = Arrays.asList(new Staff("小明", 18, new BigDecimal(2000)),
                new Staff("小明1", 33, new BigDecimal(22020)), new Staff("小明2", 44, new BigDecimal(2800)),
                new Staff("小明3", 23, new BigDecimal(2700)), new Staff("小明4", 21, new BigDecimal(2600)),
                new Staff("小明5", 10, new BigDecimal(1000)), new Staff("小明6", 56, new BigDecimal(21000)),
                new Staff("小明7", 49, new BigDecimal(12000)));

        BigDecimal reduce = asList.stream().map(c -> c.getSalary() == null ? BigDecimal.ZERO : c.getSalary())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println(reduce);
    }

    @Test
    public void test() {
        Object orElse = Optional.ofNullable(null).orElse("abc");
        int i = 1;
        for (;;) {
            System.err.println(i++);

            if (i == 100) {
                break;
            }
        }
    }

    @Test
    public void test1() {
        /*String zString = "111";
        System.err.println("zz" + zString.split(",")[0]);
        String q = "1,,";
        String[] split = q.split(",");
        System.err.println(split.length);
        System.err.println("不要逗号截取--"+split[0]);
        q.hashCode();
        System.err.println("".equals(null));*/
        String a = "1,2,3";
        String b = "1,2,3,";
        System.err.println("a" + a.split(",").length);

        System.err.println("b" + b.split(",")[2]);
    }

    @Test
    public void testDouble() {
        Double a = 0.0;
        double b = 0.0;
        Double c = 0.0;
        Integer d = 1;

        System.err.println(c == a);

        JSONObject json = new JSONObject();
        json.put("a", 1.0);
        Double object = (Double) json.get("a");
        System.err.println("强转" + object);
        Double double1 = json.getDouble("a");
        Integer double2 = json.getInteger("a");
        System.err.println("Double类型接收------" + double1);
        System.err.println("Integer类型接收------" + double2);
        int parseInt = Integer.parseInt(new java.text.DecimalFormat("0").format(1.6));
        System.err.println("double转int" + parseInt);
        System.err.println("double转int" + (int) 1.3);
    }

    /**
     * 从html中提取纯文本
     * 
     * @author wencun
     * @date: 2018年8月3日 上午9:14:27
     * @param strHtml
     * @return
     */
    public static String StripHT(String strHtml) {
        String txtcontent = strHtml.replaceAll("</?[^>]+>", ""); // 剔出<html>的标签
        txtcontent = txtcontent.replaceAll("<a>\\s*|\t|\r|\n</a>", "");// 去除字符串中的空格,回车,换行符,制表符
        return txtcontent;
    }

    /**
     * 从HTML中提取图片链接
     * 
     * @author wencun
     * @date: 2018年8月3日 上午9:08:09
     * @param content
     * @return
     */
    public static List<String> extractImg(String content) {
        List<String> srcList = new ArrayList<String>(); // 用来存储获取到的图片地址
        Pattern p = Pattern.compile("<(img|IMG)(.*?)(>|></img>|/>)");// 匹配字符串中的img标签
        Matcher matcher = p.matcher(content);
        boolean hasPic = matcher.find();
        if (hasPic == true)// 判断是否含有图片
        {
            while (hasPic) // 如果含有图片，那么持续进行查找，直到匹配不到
            {
                String group = matcher.group(2);// 获取第二个分组的内容，也就是 (.*?)匹配到的
                Pattern srcText = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");// 匹配图片的地址
                Matcher matcher2 = srcText.matcher(group);
                if (matcher2.find()) {
                    srcList.add(matcher2.group(3));// 把获取到的图片地址添加到列表中
                }
                hasPic = matcher.find();// 判断是否还有img标签
            }

        }
        return srcList;
    }

    @Test
    public void html() throws Exception {
        String content = "<p><img src=\"http://img.58yicun.com/2/20161228/36e6afc6d0488a725903a7ec9fab075f.jpg\" title=\"title\" alt=\"600-1.jpg\"/></p><p style=\"margin-top:10px;margin-right:0;margin-bottom:10px;margin-left:0;text-indent:28px;text-autospace:ideograph-numeric;text-align:justify;text-justify:inter-ideograph;line-height:24px\"><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">近日，</span></span><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">益阳</span></span><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">大通湖区千山红镇宏硕生物科技草莓园内，满棚翠绿的藤蔓上挂满了红艳艳的草莓，农户正忙着采摘。今年入冬以来，受雾霾及低温寡照天气影响，草莓较往年推迟近一个月成熟，从本月上旬开始，所有草莓品种正式上市，引来一批批体验采摘、购销的游人和客商。</span></span></p><p style=\"margin: 10px 0px; text-indent: 28px; text-align: justify; line-height: 24px;\"><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">据了解，该草莓园因地制宜选用法兰地、水蜜桃、香蕉等口味的优良草莓品种，采用高畦栽培、科学掌握温度湿度、蜜蜂授粉等关键技术，并连续三年使用绿色无污染的生物肥，使用人工除草种植大棚无公害草莓。该园草莓经大通湖区农技推广中心农产品质量溯源检测，各项指标达标，消费者可以放心购买食用。</span></span><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">（来源于益阳在线）</span></span></p>";
        List<String> extractImg = extractImg(content);
        System.err.println("图片链接：----" + extractImg);
        // String stripHT = StripHT(content);
        // System.err.println("纯文本：-----"+stripHT);
        Staff staff = new Staff();
        System.err.println(staff);

    }

    @Test
    public void json() throws Exception {
        Integer a=new Integer(1);
        Integer b=new Integer(1);
        System.err.println(a==b);
        
        StringBuffer str=new StringBuffer("当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。 ");
        StringBuilder str1=new StringBuilder("当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。 ");
        String substring = str1.substring(1, 2);
        System.err.println("substring-----"+substring);
        String str2=str+"cuo";
    }

    @Test
    public void str() throws Exception {
        String str = "hello world";
        String[] split = str.split("");
        StringBuffer buffer = new StringBuffer("");
        System.out.println(split.length);
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.println(i);
            buffer.append(split[i]);
        }
        System.out.println("倒序" + buffer.toString());
    }

    @Test
    public void getDateWeekInt() throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.err.println(c.get(Calendar.DAY_OF_WEEK));
    }

    @Test
    public void sy() throws Exception {
        //synchronized 
    }

}
