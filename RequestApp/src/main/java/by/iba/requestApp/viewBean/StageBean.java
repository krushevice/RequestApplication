package by.iba.requestApp.viewBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stages")
public class StageBean {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
	private int id;
	
	@Column(name="stage1")
	private int stageOne;
	
	@Column(name="stage2")
	private int stageTwo;
	
	@Column(name="stage3")
	private int stageThree;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStageOne() {
		return stageOne;
	}

	public void setStageOne(int stageOne) {
		this.stageOne = stageOne;
	}

	public int getStageTwo() {
		return stageTwo;
	}

	public void setStageTwo(int stageTwo) {
		this.stageTwo = stageTwo;
	}

	public int getStageThree() {
		return stageThree;
	}

	public void setStageThree(int stageThree) {
		this.stageThree = stageThree;
	}

	@Override
	public String toString() {
		return "StageBean [id=" + id + ", stageOne=" + stageOne + ", stageTwo=" + stageTwo + ", stageThree="
				+ stageThree + "]";
	}
	
}
