
package com.goku.sample.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

    private Integer id;
    private String name;
    private Integer point;
    private Integer status;
    private String image;
    private String description;
    private String createdAt;
    private String updatedAt;
    private Object deletedAt;
    private String unitNo;
    private Integer deleted;
    private String idGameMachine;
    private Integer pointCommon;
    private String endDateTime;
    private String startDateTime;
    private Integer machineId;
    private Integer sort;
    private String codeItem;
    private String listComment;
    private String commentDetail;
    private Object soundId;
    private Integer mode;
    @SerializedName("image_product")
    private List<String> imageProduct = new ArrayList<String>();
    private Pivot pivot;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The point
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * 
     * @param point
     *     The point
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * 
     * @return
     *     The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     * @param updatedAt
     *     The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * @return
     *     The deletedAt
     */
    public Object getDeletedAt() {
        return deletedAt;
    }

    /**
     * 
     * @param deletedAt
     *     The deleted_at
     */
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * 
     * @return
     *     The unitNo
     */
    public String getUnitNo() {
        return unitNo;
    }

    /**
     * 
     * @param unitNo
     *     The unit_no
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    /**
     * 
     * @return
     *     The deleted
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 
     * @param deleted
     *     The deleted
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 
     * @return
     *     The idGameMachine
     */
    public String getIdGameMachine() {
        return idGameMachine;
    }

    /**
     * 
     * @param idGameMachine
     *     The id_game_machine
     */
    public void setIdGameMachine(String idGameMachine) {
        this.idGameMachine = idGameMachine;
    }

    /**
     * 
     * @return
     *     The pointCommon
     */
    public Integer getPointCommon() {
        return pointCommon;
    }

    /**
     * 
     * @param pointCommon
     *     The point_common
     */
    public void setPointCommon(Integer pointCommon) {
        this.pointCommon = pointCommon;
    }

    /**
     * 
     * @return
     *     The endDateTime
     */
    public String getEndDateTime() {
        return endDateTime;
    }

    /**
     * 
     * @param endDateTime
     *     The end_date_time
     */
    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * 
     * @return
     *     The startDateTime
     */
    public String getStartDateTime() {
        return startDateTime;
    }

    /**
     * 
     * @param startDateTime
     *     The start_date_time
     */
    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * 
     * @return
     *     The machineId
     */
    public Integer getMachineId() {
        return machineId;
    }

    /**
     * 
     * @param machineId
     *     The machine_id
     */
    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    /**
     * 
     * @return
     *     The sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 
     * @param sort
     *     The sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 
     * @return
     *     The codeItem
     */
    public String getCodeItem() {
        return codeItem;
    }

    /**
     * 
     * @param codeItem
     *     The code_item
     */
    public void setCodeItem(String codeItem) {
        this.codeItem = codeItem;
    }

    /**
     * 
     * @return
     *     The listComment
     */
    public String getListComment() {
        return listComment;
    }

    /**
     * 
     * @param listComment
     *     The list_comment
     */
    public void setListComment(String listComment) {
        this.listComment = listComment;
    }

    /**
     * 
     * @return
     *     The commentDetail
     */
    public String getCommentDetail() {
        return commentDetail;
    }

    /**
     * 
     * @param commentDetail
     *     The comment_detail
     */
    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    /**
     * 
     * @return
     *     The soundId
     */
    public Object getSoundId() {
        return soundId;
    }

    /**
     * 
     * @param soundId
     *     The sound_id
     */
    public void setSoundId(Object soundId) {
        this.soundId = soundId;
    }

    /**
     * 
     * @return
     *     The mode
     */
    public Integer getMode() {
        return mode;
    }

    /**
     * 
     * @param mode
     *     The mode
     */
    public void setMode(Integer mode) {
        this.mode = mode;
    }

    /**
     * 
     * @return
     *     The imageProduct
     */
    public List<String> getImageProduct() {
        return imageProduct;
    }

    /**
     * 
     * @param imageProduct
     *     The image_product
     */
    public void setImageProduct(List<String> imageProduct) {
        this.imageProduct = imageProduct;
    }

    /**
     * 
     * @return
     *     The pivot
     */
    public Pivot getPivot() {
        return pivot;
    }

    /**
     * 
     * @param pivot
     *     The pivot
     */
    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
