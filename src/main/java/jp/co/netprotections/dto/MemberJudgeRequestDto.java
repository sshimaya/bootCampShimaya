package jp.co.netprotections.dto;

public class MemberJudgeRequestDto {

	private String memberName;
	private int eventPlanning;
	private int cogitation;
	private int coodination;
	private int programmingAbility;
	private int infrastructureKnowledge;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setEventPlanning(int eventPlanning) {
		this.eventPlanning = eventPlanning;
	}

	public int getEventPlanning () {
		return eventPlanning;
	}

	public void setCogitation(int cogitation) {
		this.cogitation = cogitation;
	}

	public int getCogitation () {
		return cogitation;
	}

	public void setCoodination(int coodination) {
		this.coodination = coodination;
	}

	public int getCoodination () {
		return coodination;
	}

	public void setProgrammingAbility(int programmingAbility) {
		this.programmingAbility = programmingAbility;
	}

	public int getProgrammingAbility () {
		return programmingAbility;
	}

	public void setInfrastructureKnowledge(int infrastructureKnowledge) {
		this.infrastructureKnowledge = infrastructureKnowledge;
	}

	public int getInfrastructureKnowledge () {
		return infrastructureKnowledge;
	}

}
