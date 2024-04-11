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

    public enum Strategy{
        SINGLE(1, "Single probability"),
        ENTIRETY(2, "Overall probability");

        private Integer code;
        private String info;

        Strategy(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public enum DrawState {

        FAIL(0, "NOT AWARDED"),

        SUCCESS(1, "AWARDED"),

        COVER(2, "BASIC AWARD");

        private int code;
        private String info;
        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }


        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
