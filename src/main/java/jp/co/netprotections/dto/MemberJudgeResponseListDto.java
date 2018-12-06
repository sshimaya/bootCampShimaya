package jp.co.netprotections.dto;

import java.util.List;

public class MemberJudgeResponseListDto {

	public List<MemberJudgeResponseDto> judgedCandidatesResultList;

	public List<MemberJudgeResponseDto> getJudgedCandidatesResultList() {
		return judgedCandidatesResultList;
	}

	public void setJudgedCandidatesResultList(List<MemberJudgeResponseDto> judgedCandidatesResultList) {
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	}

}
