package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * uri与url测试
 * 结论：
 * uri:/test/testUri
 * url:http://localhost:8001/test/testUri
 */
public class UriTest {

    public static void uriTest() throws URISyntaxException {
        URI uri = new URI("https://www.qiandu.com:8080/goods/index.html?username=dgh&passwd=123#j2se");
        System.out.println("scheme             : " + uri.getScheme());
        System.out.println("SchemeSpecificPart : " + uri.getSchemeSpecificPart());
        System.out.println("Authority          : " + uri.getAuthority());
        System.out.println("host               : " + uri.getHost());
        System.out.println("port               : " + uri.getPort());
        System.out.println("path               : " + uri.getPath());
        System.out.println("query              : "  + uri.getQuery());
        System.out.println("fragment           : " + uri.getFragment());
    }

    public static void urlTest() throws MalformedURLException {
        URL url = new URL("https://www.qiandu.com:8080/goods/index.html?username=dgh&passwd=123#j2se");
        System.out.println("URL：                  " + url.toString());
        System.out.println("protocol：        " + url.getProtocol());
        System.out.println("authority：      " + url.getAuthority());
        System.out.println("file name：      " + url.getFile());
        System.out.println("host：                " + url.getHost());
        System.out.println("path：                " + url.getPath());
        System.out.println("port：                " + url.getPort());
        System.out.println("default port：" + url.getDefaultPort());
        System.out.println("query：              " + url.getQuery());
        System.out.println("ref：                  " + url.getRef());
    }

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        uriTest();
//        urlTest();

    }


}
