package com.nocZaHranici.game.data;

/**
 * Třída reprezentující úkoly v souboru
 */
public class QuestData {
    /**
     * Id
     */
    private String id;
    /**
     * Jméno
     */
    private String name;
    /**
     * Popis
     */
    private String description;
    /**
     * Potřebné předměty
     */
    private String requiredItemId;
    /**
     * Text cíle
     */
    private String objectiveText;
    /**
     * Cílená postava
     */
    private String targetNpcId;
    /**
     * Id odměny
     */
    private String rewardItemId;

    /**
     * Vytvoří instanci úkolu v souboru, nastaví základní hodnoty
     * @param id Id
     * @param name Jméno
     * @param description Popis
     * @param requiredItemId Potřebné předměty
     * @param targetNpcId Cílená postava
     * @param rewardItemId Id odměny
     * @param objectiveText Text cíle
     */
    public QuestData(String id, String name, String description,
                     String requiredItemId, String targetNpcId,
                     String rewardItemId, String objectiveText) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.requiredItemId = requiredItemId;
        this.targetNpcId = targetNpcId;
        this.rewardItemId = rewardItemId;
        this.objectiveText = objectiveText;
    }


    public QuestData() {}

    // region get, set

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredItemId() {
        return requiredItemId;
    }

    public void setRequiredItemId(String requiredItemId) {
        this.requiredItemId = requiredItemId;
    }

    public String getTargetNpcId() {
        return targetNpcId;
    }

    public void setTargetNpcId(String targetNpcId) {
        this.targetNpcId = targetNpcId;
    }

    public String getRewardItemId() {
        return rewardItemId;
    }

    public void setRewardItemId(String rewardItemId) {
        this.rewardItemId = rewardItemId;
    }

    public String getObjectiveText() {
        return objectiveText;
    }

    public void setObjectiveText(String objectiveText) {
        this.objectiveText = objectiveText;
    }

// endregion
}
