package cn.roilat.study.tools.wechat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.nio.file.Files;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class GetGroupUsersInfo {

    public static void main(String[] args) throws IOException {
        copyFiles("C:\\Users\\wb-dtw368035\\Desktop\\users\\原始数据\\邻居群",                "C:\\Users\\wb-dtw368035\\Desktop\\users\\处理后的数据\\邻居群");
       dealFiles();
    }

    public static void dealFiles() throws IOException {

        File file = new File("C:\\Users\\wb-dtw368035\\Desktop\\users\\处理后的数据\\邻居群");
        File[] files = file.listFiles();
        for (File f : files) {
            String fileName = f.getName();
            fileName = fileName.replaceAll("_", "-").replaceAll("--", "-").replaceAll("—", "-").replaceAll("栋", "-");
            if (fileName.indexOf("-") <= 0) {
                fileName = "10-" + fileName;
            }
            if(fileName.matches("-\\d{2}楼-\\d{2}")) {
                System.out.println(fileName);
            }
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(fileName);
            //            while(matcher.find()) {
            //                System.out.println(matcher.group());
            //            }
            f.renameTo(new File(file.getAbsolutePath() + File.separator +fileName));
        }

    }

    public static void copyFiles(String srcPath, String destPath) throws IOException {
        File file = new File(srcPath);
        File[] files = file.listFiles();
        File temp;
        Set<String> set = new HashSet<String>();
        StringBuffer sb = new StringBuffer();
        for (File f : files) {
            sb.append(f.getName()).delete(0, sb.indexOf("-") + 1);
            if(set.contains(sb.toString())) {
                sb.append("-01");
            }
            temp = new File(destPath + File.separator + sb.toString());
            set.add(temp.getName());
            sb.setLength(0);
            //f.renameTo(temp);
            //Files.copy(source, target);
            FileUtils.copyFile(f, temp);
        }
    }

    public static void copyFile(File src, File dest) {
        try (FileInputStream fis = new FileInputStream(src);
                FileOutputStream fos = new FileOutputStream(dest);
                FileChannel fc1 = fis.getChannel();
                FileChannel fc2 = fos.getChannel();) {
            fc1.transferTo(0, src.length(), fc2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * 
/cgi-bin/mmwebwx-bin/webwxgeticon?seq=0&username=@f2f8bdeb127396e46ee67347bec2a66d&chatroomid=@b2b6d7fc57376693c73234d01ab7140c&skey=&type=big
/cgi-bin/mmwebwx-bin/webwxgeticon?seq=0&username=@f2f8bdeb127396e46ee67347bec2a66d&chatroomid=@b2b6d7fc57376693c73234d01ab7140c&skey=

function funDownload(src, filename) {
    // 创建隐藏的可下载链接
    var eleLink = document.createElement('a');
    eleLink.download = filename;
    eleLink.style.display = 'none';
    // 字符内容转变成blob地址
    //var blob = new Blob([content]);
    eleLink.href = src;
    // 触发点击
    document.body.appendChild(eleLink);
    eleLink.click();
    // 然后移除
    document.body.removeChild(eleLink);
};
var divs = $('#mmpop_chatroom_members > div > div > div.scrollbar-dynamic.members_inner.ng-scope.scroll-content.scroll-scrolly_visible > div');
$(divs).each(function(i,e){
    var name = i + "-" + $(e).children('p').html()+".jpg";
    var url = "https://wx2.qq.com" + $(e).children('img').attr('src') + "&type=big";
    funDownload(url,name);
});
 */
