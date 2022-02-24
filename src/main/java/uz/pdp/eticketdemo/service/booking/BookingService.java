package uz.pdp.eticketdemo.service.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.entity.booking.BookingEntity;
import uz.pdp.eticketdemo.repository.booking.BookingRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements BaseService<BookingEntity> {

    private final BookingRepository bookingRepository;

    @Override
    public ApiResponse getList() {
        return null;
    }

    @Override
    public ApiResponse getById(Long id) {
        return null;
    }

    @Override
    public ApiResponse delete(Long id) {
        return null;
    }

    @Override
    public ApiResponse edit(Long id, BookingEntity item) {
        return null;
    }

    @Override
    public ApiResponse add(BookingEntity item) {
        return null;
    }

    public long getOccupiedSeatNumbers(int fInd, int lInd, long trainId, LocalDateTime date){
        long ans = 0;
        long cnt = 1L << (fInd - 1) ;
        while(fInd + 1 < lInd){
            cnt += (1L << fInd);
            fInd++;
        }

        List<BookingEntity> list = bookingRepository.getAllByTrainIdAndTravelDate(trainId, date);
        for (BookingEntity bookingEntity : list) {
            long l = bookingEntity.getSeatOccupationInterval() & cnt;
            if(l != 0) ans++;
        }
        return ans;
    }

}
