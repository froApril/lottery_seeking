package lottery.common;

public class Constants {

    public enum ResponseCode {
        SUCCESS("0000", "Success"),
        UN_ERROR("0001","Unknown failure"),
        ILLEGAL_PARAMETER("0002","Invalid argument"),
        INDEX_DUP("0003","Primary key conflict");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

        }
}
