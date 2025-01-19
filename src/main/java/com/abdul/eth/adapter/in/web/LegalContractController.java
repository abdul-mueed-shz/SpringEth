package com.abdul.eth.adapter.in.web;

import com.abdul.eth.domain.ethereum.model.BlockInfo;
import com.abdul.eth.domain.ethereum.model.LegalContractInfo;
import com.abdul.eth.domain.ethereum.port.in.CreateLegalContractUseCase;
import com.abdul.eth.domain.ethereum.port.in.GetBlockNumberUseCase;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/legal-contract")
@RequiredArgsConstructor
public class LegalContractController {

    private final GetBlockNumberUseCase getBlockNumberUseCase;
    private final CreateLegalContractUseCase createLegalContractUseCase;

    @GetMapping("/block-number")
    public ResponseEntity<BlockInfo> getBlockNumber() throws IOException {
        return ResponseEntity.ok(getBlockNumberUseCase.get());
    }

    @PostMapping
    public ResponseEntity<LegalContractInfo> createLegalContract(@RequestBody LegalContractInfo legalContractInfo)
            throws Exception {
        return ResponseEntity.ok(
                createLegalContractUseCase.execute(legalContractInfo)
        );
    }
}
