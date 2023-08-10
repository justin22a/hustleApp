package com.hustle.hustle.model;

public class OfferComment {
    private User user;
    private String comment;
    private Long postID;
    private Long commentID;
    private String postedDate;
    private String endDate;
    private Product product;
    private String type;

    public OfferComment() {
    }
    
    //sell comment
    public OfferComment(User user, String comment, Long postID, Long commentID, String postedDate, String endDate, Product product, String type) {
        this.user = user;
        this.comment = comment;
        this.postID = postID;
        this.commentID = commentID;
        this.postedDate = postedDate;
        this.endDate = endDate;
        this.product = product;
        this.type = type;
    }

    //buy comment
    public OfferComment(User user, String comment, Long postID, Long commentID, String postedDate, String endDate, String type) {
        this.user = user;
        this.comment = comment;
        this.postID = postID;
        this.commentID = commentID;
        this.postedDate = postedDate;
        this.endDate = endDate;
        this.type = type;
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getComment() {
        return comment;
    }

    public Long getPostID() {
        return postID;
    }

    public Long getCommentID() {
        return commentID;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getType() {
        return type;
    }

    public String getProductName() {
        return product.getName();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
