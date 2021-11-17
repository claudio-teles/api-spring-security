package claudioteles.com.github.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.models.Spreadsheet;

@Repository
public interface SpreadsheetDao extends JpaRepository<Spreadsheet, Long> {

}
