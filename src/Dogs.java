/**
 * The type Dogs.
 */
public class Dogs {

private String id;
private String ownerName;
private String ownerEmail;
private String ownerPhone;
private String dogName;

    /**
     * Instantiates a new Dogs.
     *
     * @param id         the id
     * @param ownerName  the owner name
     * @param ownerEmail the owner email
     * @param ownerPhone the owner phone
     * @param dogName    the dog name
     */
    public Dogs(String id, String ownerName, String ownerEmail, String ownerPhone, String dogName) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
        this.dogName = dogName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets owner name.
     *
     * @return the owner name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets owner name.
     *
     * @param ownerName the owner name
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Gets owner email.
     *
     * @return the owner email
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }

    /**
     * Sets owner email.
     *
     * @param ownerEmail the owner email
     */
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    /**
     * Gets owner phone.
     *
     * @return the owner phone
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }

    /**
     * Sets owner phone.
     *
     * @param ownerPhone the owner phone
     */
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    /**
     * Gets dog name.
     *
     * @return the dog name
     */
    public String getDogName() {
        return dogName;
    }

    /**
     * Sets dog name.
     *
     * @param dogName the dog name
     */
    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
}
