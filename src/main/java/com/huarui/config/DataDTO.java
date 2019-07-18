package com.huarui.config;

import java.util.ArrayList;

/**
 * Created by sloan on 2019/7/15.
 */
public class DataDTO {

    private String resultcode;
    private String reason;
    private Result result;
    private int error_code;

    public static class Result {
        private ArrayList<Data> data;
        private String totalNum;
        private int pn;
        private String rn;

        public ArrayList<Data> getData() {
            return data;
        }

        public void setData(ArrayList<Data> data) {
            this.data = data;
        }

        public String getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(String totalNum) {
            this.totalNum = totalNum;
        }

        public int getPn() {
            return pn;
        }

        public void setPn(int pn) {
            this.pn = pn;
        }

        public String getRn() {
            return rn;
        }

        public void setRn(String rn) {
            this.rn = rn;
        }
    }

    public static class Steps {
        private String img;
        private String step;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }
    }

    public static class Data {
        private String id;
        private String title;
        private String tags;
        private String imtro;
        private String ingredients;
        private String burden;
        private ArrayList<String> albums;
        private ArrayList<Steps> steps;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getImtro() {
            return imtro;
        }

        public void setImtro(String imtro) {
            this.imtro = imtro;
        }

        public String getIngredients() {
            return ingredients;
        }

        public void setIngredients(String ingredients) {
            this.ingredients = ingredients;
        }

        public String getBurden() {
            return burden;
        }

        public void setBurden(String burden) {
            this.burden = burden;
        }

        public ArrayList<String> getAlbums() {
            return albums;
        }

        public void setAlbums(ArrayList<String> albums) {
            this.albums = albums;
        }

        public ArrayList<Steps> getSteps() {
            return steps;
        }

        public void setSteps(ArrayList<Steps> steps) {
            this.steps = steps;
        }
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }


}
