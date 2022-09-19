package org.hyhr.domain.service.receipts;

import lombok.RequiredArgsConstructor;
import org.hyhr.domain.receipts.Receipts;
import org.hyhr.domain.receipts.ReceiptsRepository;
import org.hyhr.web.dto.ReceiptsResponseDto;
import org.hyhr.web.dto.ReceiptsSaveRequestDto;
import org.hyhr.web.dto.ReceiptsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReceiptsService {
    private final ReceiptsRepository receiptsRepository;

    @Transactional
    public Long save(ReceiptsSaveRequestDto requestDto){
        return receiptsRepository.save(requestDto.toEntity()).getId();
    }

    // TODO api for the list of receipts
//    public Long saveAll(List<ReceiptsSaveRequestDto> requestDtos){
//        return receiptsRepository.saveAll(requestDtos.toEntity());
//    }
    @Transactional
    public Long update(Long id, ReceiptsUpdateRequestDto requestDto){
        Receipts receipts = receiptsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no receipt. id=" + id));
        receipts.update(requestDto.getTitle(), requestDto.getUploader());

        return id;
    }
    @Transactional
    public void delete(Long id){
        // check for existence first.
        receiptsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no receipt. id=" + id));
        // then delete.
        receiptsRepository.deleteById(id);
    }

    public ReceiptsResponseDto findById(Long id){
        Receipts entity = receiptsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no receipt. id=" + id));

        return new ReceiptsResponseDto(entity);
    }
}
