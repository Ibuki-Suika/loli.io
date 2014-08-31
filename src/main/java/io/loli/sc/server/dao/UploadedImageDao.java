package io.loli.sc.server.dao;

import io.loli.sc.server.entity.UploadedImage;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("imageDao")
public class UploadedImageDao {
    @PersistenceContext
    private EntityManager em;

    public void save(UploadedImage image) {
        em.persist(image);
    }

    public void update(UploadedImage image) {
        em.merge(image);
    }

    /**
     * 根据图片id将查询出此图片的信息
     * 
     * @param id 图片的id
     * @return 查询出的图片，如果没有此id的图片，则返回null
     */
    public UploadedImage findById(int id) {
        return em.find(UploadedImage.class, id);
    }

    /**
     * 分页查询出指定用户的截图列表
     * 
     * @param u_id 用户id
     * @param firstPosition 初始位置
     * @param maxResults 每页的最大数量
     * @return 截图列表
     */
    public List<UploadedImage> listByUId(int u_id, int firstPosition, int maxResults) {

        return em.createNamedQuery("UploadedImage.listByUId", UploadedImage.class)
                .setParameter("u_id", u_id).setFirstResult(firstPosition).setMaxResults(maxResults)
                .getResultList();
    }

    public int countByUId(int u_id) {
        return em.createNamedQuery("UploadedImage.listByUId", UploadedImage.class)
                .setParameter("u_id", u_id).getResultList().size();

    }

    public List<UploadedImage> listByUIdAndFileName(int u_id, String fileName, int firstPosition,
            int maxResults) {
        return em.createNamedQuery("UploadedImage.listByUIdAndFileName", UploadedImage.class)
                .setParameter("file_name", "%" + fileName + "%").setParameter("u_id", u_id)
                .setFirstResult(firstPosition).setMaxResults(maxResults).getResultList();
    }

    public List<UploadedImage> listByUIdAndFileName(int u_id, String fileName, int firstPosition,
            int maxResults, int tag) {
        return em.createNamedQuery("UploadedImage.listByUIdAndFileNameAndTag", UploadedImage.class)
                .setParameter("file_name", "%" + fileName + "%").setParameter("u_id", u_id)
                .setParameter("tag_id", tag).setFirstResult(firstPosition)
                .setMaxResults(maxResults).getResultList();
    }

    public int countByUIdAndFileName(int u_id, String fileName) {
        return em.createNamedQuery("UploadedImage.listByUIdAndFileName", UploadedImage.class)
                .setParameter("u_id", u_id).setParameter("file_name", "%" + fileName + "%")
                .getResultList().size();
    }

    public int countByUIdAndFileName(int u_id, String fileName, int tag) {
        return em.createNamedQuery("UploadedImage.listByUIdAndFileNameAndTag", UploadedImage.class)
                .setParameter("u_id", u_id).setParameter("file_name", "%" + fileName + "%")
                .setParameter("tag_id", tag).getResultList().size();
    }

    public List<UploadedImage> checkExists(String code) {
        return em.createQuery("from UploadedImage where generated_code=:code", UploadedImage.class)
                .setParameter("code", code).getResultList();
    }
}