package com.abdul.eth.domain.ethereum.port.in;

import java.util.List;

public interface DeployContractUseCase {

    String execute(List<String> contractParticipants) throws Exception;
}
