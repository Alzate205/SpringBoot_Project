package cue.edu.co.VeloceRentalsSpring.velocerentals.mapping;


import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.TransactionDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.model.models.Transaction;

/**
 * This class is responsible for mapping between TransactionDto and Transaction model.
 * It provides methods to convert between these two representations.
 */
public class TransactionMapper {

    /**
     * Maps a TransactionDto object to a Transaction object.
     *
     * @param transactionDto the TransactionDto object to be mapped
     * @return a Transaction object with the same data as the input TransactionDto
     */
    public static Transaction mapFromDTO(TransactionDto transactionDto){
        return Transaction.builder()
               .id(transactionDto.id())
               .reservation(transactionDto.reservation())
               .amount(transactionDto.amount())
               .dateTime(transactionDto.dateTime())
               .payMethods(transactionDto.payMethods())
               .status(transactionDto.status())
               .build();
    }

    /**
     * Maps a Transaction object to a TransactionDto object.
     *
     * @param transaction the Transaction object to be mapped
     * @return a TransactionDto object with the same data as the input Transaction
     */
    public static TransactionDto mapFromModel(Transaction transaction){
        return TransactionDto.builder()
               .id(transaction.getId())
               .reservation(transaction.getReservation())
               .amount(transaction.getAmount())
               .dateTime(transaction.getDateTime())
               .payMethods(transaction.getPayMethods())
               .status(transaction.getStatus())
               .build();
    }
}
