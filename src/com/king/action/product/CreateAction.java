package com.king.action.product;

import com.king.dao.Dao;
import com.king.model.Product;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.*;

/**
 * Created by king on 2017/5/11.
 */
public class CreateAction extends ActionSupport{
    private Product product;

    private File image;
    private String imageFileName;
    private String imageContentType;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String execute() throws IOException {
        ServletContext context = ServletActionContext.getServletContext();
        if (imageFileName==null){
            this.addActionError("图片不能为空！");
            return INPUT;
        }
        if (!imageFileName.equals("")) {

            String fn=path+product.getId()+imageFileName.substring(imageFileName.lastIndexOf("."));
            product.setProductPicture(product.getId()+imageFileName.substring(imageFileName.lastIndexOf(".")));
            FileOutputStream fileOutputStream=new FileOutputStream(fn);
            InputStream inputStream=new FileInputStream(image);
            byte[] buffer=new byte[8192];
            int count=0;
            while ((count = inputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer,0,count);
            }
            fileOutputStream.close();
            inputStream.close();
        }else {
            this.addActionError("图片不能为空！");
            return INPUT;
        }

        try {
            Dao.executeSQL(Dao.I, product);
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError(e.toString());
            return INPUT;
        }
        return SUCCESS;
    }
}
