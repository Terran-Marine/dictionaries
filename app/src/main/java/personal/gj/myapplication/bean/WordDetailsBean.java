package personal.gj.myapplication.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by GJ
 * on 2018/12/18 -上午 10:59
 */
public class WordDetailsBean {


    /**
     * tSpeakUrl : http://openapi.youdao.com/ttsapi?q=å¥½&langType=zh-CHS&sign=BABBA857780372EB19255FB24ADE70ED&salt=1545102084388&voice=4&format=mp3&appKey=35525f36bb7e9e31
     * web : [{"value":["好的","提供关于","善","良好"],"key":"good"},{"value":["耶稣受难节","耶稣受难日","受难节","受难日"],"key":"Good Friday"},{"value":["吉芬商品","吉芬物品","吉芬品","季芬财"],"key":"Giffen Good"}]
     * query : good
     * translation : ["好"]
     * errorCode : 0
     * dict : {"url":"yddict://m.youdao.com/dict?le=eng&q=good"}
     * webdict : {"url":"http://m.youdao.com/dict?le=eng&q=good"}
     * basic : {"us-phonetic":"ɡʊd","phonetic":"gʊd","uk-phonetic":"gʊd","wfs":[{"wf":{"name":"比较级","value":"better"}},{"wf":{"name":"最高级","value":"best"}}],"uk-speech":"http://openapi.youdao.com/ttsapi?q=good&langType=en&sign=875C200A9D811E0CF14F767604CD3DAD&salt=1545102084388&voice=5&format=mp3&appKey=35525f36bb7e9e31","explains":["adj. 好的；优良的；愉快的；虔诚的","n. 好处；善行；慷慨的行为","adv. 好","n. (Good)人名；(英)古德；(瑞典)戈德"],"us-speech":"http://openapi.youdao.com/ttsapi?q=good&langType=en&sign=875C200A9D811E0CF14F767604CD3DAD&salt=1545102084388&voice=6&format=mp3&appKey=35525f36bb7e9e31"}
     * l : EN2zh-CHS
     * speakUrl : http://openapi.youdao.com/ttsapi?q=good&langType=en&sign=875C200A9D811E0CF14F767604CD3DAD&salt=1545102084388&voice=4&format=mp3&appKey=35525f36bb7e9e31
     */

    public String tSpeakUrl;
    public String query;
    public String errorCode;
    public DictBean dict;
    public WebdictBean webdict;
    public BasicBean basic;
    public String l;
    public String speakUrl;
    public List<WebBean> web;
    public List<String> translation;

    public static class DictBean {
        /**
         * url : yddict://m.youdao.com/dict?le=eng&q=good
         */

        public String url;
    }

    public static class WebdictBean {
        /**
         * url : http://m.youdao.com/dict?le=eng&q=good
         */

        public String url;
    }

    public static class BasicBean {
        /**
         * us-phonetic : ɡʊd
         * phonetic : gʊd
         * uk-phonetic : gʊd
         * wfs : [{"wf":{"name":"比较级","value":"better"}},{"wf":{"name":"最高级","value":"best"}}]
         * uk-speech : http://openapi.youdao.com/ttsapi?q=good&langType=en&sign=875C200A9D811E0CF14F767604CD3DAD&salt=1545102084388&voice=5&format=mp3&appKey=35525f36bb7e9e31
         * explains : ["adj. 好的；优良的；愉快的；虔诚的","n. 好处；善行；慷慨的行为","adv. 好","n. (Good)人名；(英)古德；(瑞典)戈德"]
         * us-speech : http://openapi.youdao.com/ttsapi?q=good&langType=en&sign=875C200A9D811E0CF14F767604CD3DAD&salt=1545102084388&voice=6&format=mp3&appKey=35525f36bb7e9e31
         */

        @SerializedName("us-phonetic")
        public String usphonetic;
        public String phonetic;
        @SerializedName("uk-phonetic")
        public String ukphonetic;
        @SerializedName("uk-speech")
        public String ukspeech;
        @SerializedName("us-speech")
        public String usspeech;
        public List<WfsBean> wfs;
        public List<String> explains;

        public static class WfsBean {
            /**
             * wf : {"name":"比较级","value":"better"}
             */

            public WfBean wf;

            public static class WfBean {
                /**
                 * name : 比较级
                 * value : better
                 */

                public String name;
                public String value;
            }
        }
    }

    public static class WebBean {
        /**
         * value : ["好的","提供关于","善","良好"]
         * key : good
         */

        public String key;
        public List<String> value;
    }
}
