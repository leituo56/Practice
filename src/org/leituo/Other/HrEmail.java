package org.leituo.Other;

import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuolei on 9/24/15.
 */
public class HrEmail {

    String getMD5(String src) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(src.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method
        StringBuilder sb = new StringBuilder();
        for (byte singleByte : byteData) {
            sb.append(Integer.toString((singleByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    String encode(String myEmail, String key) throws Exception{
        return this.getMD5(this.getMD5(myEmail) + key + this.getMD5(key));
    }

    public static void main(String[] args) throws Exception{
        HrEmail test = new HrEmail();
        String myEmail = "yixiaomeng@gmail.com";

        String secret = "edd27b2c9ccb9f1734f060e281ff544de57b5bd25ccde687d9402b2079850e81c67ec0d983b2dc2b1cbad72026f6c7fab2c22950f55fe1db057407b6d452b3e07656f7b70b4099a4aae9a4471d48920c9c95dbe0ebb5c22e0e0813cc045efd019c52f123bd7c83cb4d3c010e353bce572446484218d68f445330e8772eb50e5094b6378d773c543b8cf00fd5d66a16a01d0aff25a3784f60c58cff71496a23fd41758ffd1ad6bdb5fc8e2f2a38a667c8951175d6670c91880117f49e1fa5a606dff49b32ace55bb9a1068c1475cf8a70ab62434f49653b445e341e7569567a65630f6085528d41e5985e66e1f86f919584f5a388f3bf37942fec9a15e02ccb22bb6851c5366bcf92dc1ae578f0f536c2d7128c6f4c681afd0bdafb1d853e017c78863b88c60d48f312b4e32edc3841acd7b3b4ce0175ccd876400fc23dc92efebfe71f942cbe32575c814a3160879895ec120fc760685df8aab81d2afc67343d00aa22f5fff4816d221e31ded81dbf57f7e7daa745890a89e97e82b4cf553141351baf3d066e35e6287875f8e18ed2d108cab9239b5ae6b729488c387883e0e949acd3cbb5c704a904560528c89cac673ec1155c294fb357bf98685eadfc876c";
        List<String> secretList = new LinkedList<>();
        for (int i = 0; i * 32 < secret.length(); i++ ) {
            secretList.add(secret.substring(i * 32, i * 32 + 32));
        }

        String candidate = "_.@+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        int round = 0;
        for (String subSecret:secretList) { // 28
            boolean founded = false;
            round++;
            System.out.println("Round:" + round + " decoding:" + subSecret);

            for (int i = 0; i < candidate.length() && !founded; i++) { // 66
                for (int j = 0; j < candidate.length() && !founded; j++) { // 66
                    String test2Char = String.valueOf(candidate.charAt(i)) + candidate.charAt(j);
                    String encodedWithTest = test.encode(myEmail, sb.toString() + test2Char);
                    if(subSecret.equals(encodedWithTest)) {
                        sb.append(test2Char);
                        founded = true;
                        System.out.println("Founded:" + sb.toString());
                    }
                }
            }
        }

        System.out.println("The Email is: " + sb.toString());
    }
}

