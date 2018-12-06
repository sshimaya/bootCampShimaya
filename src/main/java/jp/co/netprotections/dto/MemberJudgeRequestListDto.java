package jp.co.netprotections.dto;

import java.util.List;

public class MemberJudgeRequestListDto {

	private List<MemberJudgeRequestDto> memberCandidatesList;

	public List<MemberJudgeRequestDto> getMemberCandidatesList() {
		return memberCandidatesList;
	}

	public void setMemberCandidatesList(List<MemberJudgeRequestDto> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
	}

}
