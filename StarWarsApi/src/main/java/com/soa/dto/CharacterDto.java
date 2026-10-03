package com.soa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterDto {
	private Integer id;
	private String name;
    private String height;
    private String mass;
    private String url;
    
    @JsonProperty("hair_color")
    private String hairColor;
    
    @JsonProperty("skin_color")
    private String skinColor;
    
    @JsonProperty("eye_color")
    private String eyeColor;
    
    @JsonProperty("birth_year")
    private String birthYear;
    
    private String gender;
    
    
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/**
	 * @return the mass
	 */
	public String getMass() {
		return mass;
	}
	/**
	 * @param mass the mass to set
	 */
	public void setMass(String mass) {
		this.mass = mass;
	}
	/**
	 * @return the hairColor
	 */
	public String getHairColor() {
		return hairColor;
	}
	/**
	 * @param hairColor the hairColor to set
	 */
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	/**
	 * @return the skinColor
	 */
	public String getSkinColor() {
		return skinColor;
	}
	/**
	 * @param skinColor the skinColor to set
	 */
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}
	/**
	 * @return the eyeColor
	 */
	public String getEyeColor() {
		return eyeColor;
	}
	/**
	 * @param eyeColor the eyeColor to set
	 */
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	/**
	 * @return the birthYear
	 */
	public String getBirthYear() {
		return birthYear;
	}
	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
