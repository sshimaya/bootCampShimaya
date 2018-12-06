package jp.co.netprotections.service;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;

public class MemberJudgeService {

	public MemberJudgeResponseDto service(MemberJudgeRequestDto request) {

//serviceメソッドには要素で渡す。

		MemberJudgeResponseDto response = new MemberJudgeResponseDto();
		int totalScore = totalScore(request.getEventPlanning(), request.getCogitation(), request.getCoodination(), request.getProgrammingAbility(), request.getInfrastructureKnowledge());

		if (request.getEventPlanning() <= 1 || request.getCoodination() <= 1 || totalScore <= 10) {
			response.setMemberName(request.getMemberName());
			response.setEnlistedPropriety(false);
		} else {
			response.setMemberName(request.getMemberName());
			response.setEnlistedPropriety(true);
		}

		return response;
	}

	public int totalScore (int a, int b, int c, int d, int e) {
		return a + b + c + d + e;
	}

}
