//package utilities;
//
//
//import java.util.Map;
//
//import org.apache.commons.collections4.map.HashedMap;
//import org.json.JSONObject;
//import org.openqa.selenium.devtools.DevTools;
////import org.openqa.selenium.devtools.v133.network.model.Request;
//import org.openqa.selenium.devtools.v135.network.Network;
//import org.openqa.selenium.devtools.v135.network.model.Request;
//import org.openqa.selenium.devtools.v135.network.model.RequestId;
//import org.openqa.selenium.devtools.v135.network.model.Response;
//
//import com.google.common.base.Predicate;
//
//public class ApiInterceptorUtil {
//
//    public final DevTools devTools;
//    public String extractedMessage;
//
//    // Track request methods
//    private final Map<RequestId, String> requestMethods = new HashedMap<>();
//
//    public ApiInterceptorUtil(DevTools devTools) {
//        this.devTools = devTools;
//    }
//
//    public void enableNetworkMonitoring() {
////        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//        devTools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
//
//        // Track HTTP methods for each request
//        devTools.addListener(Network.requestWillBeSent(), request -> {
//            RequestId requestId = request.getRequestId();
//            Request req = request.getRequest();
//            requestMethods.put(requestId, req.getMethod());
//        });
//    }
//
//    public void listenForResponseWithMessage(Predicate<String> urlMatcher, String messageKey) {
//        devTools.addListener(Network.responseReceived(), response -> {
//            RequestId requestId = response.getRequestId();
//            Response res = response.getResponse();
//            String url = res.getUrl();
//            int status = res.getStatus();
//
//            String method = requestMethods.getOrDefault(requestId, "");
//            if (method.equalsIgnoreCase("OPTIONS")) {
//                System.out.println("⛔ Skipping preflight OPTIONS request: " + url);
//                return;
//            }
//
//            if (status >= 300 && status < 400) {
//                System.out.println("🔁 Skipping redirect: " + url);
//                return;
//            }
//
//            if (urlMatcher.test(url)) {
//                try {
//                    Network.GetResponseBodyResponse body = devTools.send(Network.getResponseBody(requestId));
//                    String bodyStr = body.getBody();
//                    JSONObject json = new JSONObject(bodyStr);
//
//                    if (json.has(messageKey)) {
//                        extractedMessage = json.getString(messageKey);
//                        System.out.println("✅ Extracted message: " + extractedMessage);
//                    } else {
//                        System.out.println("⚠️ Message key not found in response body.");
//                    }
//
//                } catch (Exception e) {
//                    System.err.println("❌ Error reading/parsing response body: " + e.getMessage());
//                    System.err.println("⚠️ Possibly accessing invalid requestId or preflight/redirect response.");
//                }
//            }
//        });
//    }
//
//    public String getExtractedMessage() {
//        return extractedMessage;
//    }
//}
//
//
//
//
////package utilities;
////
////import org.json.JSONObject;
////import org.openqa.selenium.devtools.DevTools;
////import org.openqa.selenium.devtools.v135.network.Network;
////import org.openqa.selenium.devtools.v135.network.model.*;
////
////import java.util.*;
////import java.util.function.Predicate;
////
////public class ApiInterceptorUtil {
////
////    public final DevTools devTools;
////    public String extractedMessage;
////    private final Map<RequestId, String> requestUrlMap = new HashMap<>();
////
////    public ApiInterceptorUtil(DevTools devTools) {
////        this.devTools = devTools;
////    }
////
////    public void enableNetworkMonitoring() {
////        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
////
////        // Track requests to handle redirects
////        devTools.addListener(Network.requestWillBeSent(), request -> {
////            requestUrlMap.put(request.getRequestId(), request.getRequest().getUrl());
////        });
////    }
////
////    public void listenForResponseWithMessage(Predicate<String> urlMatcher, String messageKey) {
////        devTools.addListener(Network.responseReceived(), response -> {
////            Response res = response.getResponse();
////            int status = res.getStatus();
////            RequestId requestId = response.getRequestId();
////            String url = res.getUrl();
////
////            // Skip redirects or errors
////            if (status >= 300 && status < 400) {
////                System.out.println("🔁 Skipping redirect: " + url);
////                return;
////            }
////
////            if (urlMatcher.test(url)) {
////                try {
////                    // Try to get body only for valid response
////                    Network.GetResponseBodyResponse body = devTools.send(Network.getResponseBody(requestId));
////                    String bodyStr = body.getBody();
////                    JSONObject json = new JSONObject(bodyStr);
////
////                    if (json.has(messageKey)) {
////                        extractedMessage = json.getString(messageKey);
////                        System.out.println("✅ Extracted message: " + extractedMessage);
////                    } else {
////                        System.out.println("⚠️ Message key not found in response body.");
////                    }
////
////                } catch (Exception e) {
////                    System.err.println("❌ Error reading/parsing response body: " + e.getMessage());
////                    System.err.println("⚠️ Possibly accessing invalid requestId or preflight response.");
////                }
////            }
////        });
////    }
////    
////
////    public String getExtractedMessage() {
////        return extractedMessage;
////    }
////}
////
////package utilities;
////
////import org.json.JSONObject;
////import org.openqa.selenium.devtools.DevTools;
////import org.openqa.selenium.devtools.v133.network.Network;
////import org.openqa.selenium.devtools.v133.network.model.RequestId;
////import org.openqa.selenium.devtools.v133.network.model.Response;
////
////import java.util.Optional;
////import java.util.function.Predicate;
////
////public class ApiInterceptorUtil {
////
////    public final DevTools devTools;
////    public String extractedMessage;
////
////    public ApiInterceptorUtil(DevTools devTools) {
////        this.devTools = devTools;
////    }
////
////    public void enableNetworkMonitoring() {
////        devTools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
////    }
////
////    public void listenForResponseWithMessage(Predicate<String> urlMatcher, String messageKey) {
////        devTools.addListener(Network.responseReceived(), response -> {
////            Response res = response.getResponse();
////            String url = res.getUrl();
////
////            if (urlMatcher.test(url)) {
////                try {
////                    RequestId requestId = response.getRequestId();
////                    Network.GetResponseBodyResponse body = devTools.send(Network.getResponseBody(requestId));
////                    JSONObject json = new JSONObject(body.getBody());
////
////                    if (json.has(messageKey)) {
////                        extractedMessage = json.getString(messageKey);
////                    }
////                } catch (Exception e) {
////                    System.err.println("❌ Error reading or parsing response body: " + e.getMessage());
////                }
////            }
////        });
////    }
////
////    public String getExtractedMessage() {
////        return extractedMessage;
////    }
////}
//
//
//
//
//
