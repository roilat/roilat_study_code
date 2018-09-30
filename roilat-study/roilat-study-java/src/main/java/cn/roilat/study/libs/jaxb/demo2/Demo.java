package cn.roilat.study.libs.jaxb.demo2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import cn.roilat.study.libs.jaxb.demo2.model.GraphMap;

public class Demo {
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(GraphMap.class);

        StreamSource xml = new StreamSource(
            "src/main/java/cn/roilat/study/libs/jaxb/demo2/demo.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<GraphMap> je1 = unmarshaller.unmarshal(xml, GraphMap.class);
        GraphMap graphMap = je1.getValue();
        System.out.println(graphMap.getConfigs().get(0).getType());
        System.out.println(graphMap);
        Pattern elExprP = Pattern.compile("\\$\\{([^\\}]+)\\}");
        Matcher matcher = elExprP.matcher("${asdfasdfadslf}");
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.groupCount());
            System.out.println(matcher.end() + "--" + matcher.start());
            System.out.println(matcher.group(1));
        }
        String s = null;
        switch (s) {
            default:
                System.out.println("default");
                if(s == null) {
                    break;
                }
            case "1":
                System.out.println("case 1");
                break;
            case "2":
                System.out.println("case 2");
                break;
        }
    }
}
