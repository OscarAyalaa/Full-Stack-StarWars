package com.soa.dto;

import java.util.List;

public class SwapiPeopleResponse {
	private int count;
    private String next;
    private String previous;
    private List<CharacterDto> results;
    
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the next
	 */
	public String getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(String next) {
		this.next = next;
	}
	/**
	 * @return the previous
	 */
	public String getPrevious() {
		return previous;
	}
	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	/**
	 * @return the results
	 */
	public List<CharacterDto> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<CharacterDto> results) {
		this.results = results;
	}
}
