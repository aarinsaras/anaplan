/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.accenture.client.anaplan.parser.csv;

import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author prajwal.ravishankar
 */
public class CsvParser {

    private static final Logger LOG = LoggerFactory.getLogger(CsvParser.class);
    public List<CSVRecord> parse(Reader reader, String[] fileHeaderMapping) {

        try {
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(fileHeaderMapping);
            CSVParser csvFileParser = new CSVParser(reader, csvFileFormat);
            return csvFileParser.getRecords();
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Error parsing csv file : " + Arrays.asList(fileHeaderMapping));
        }
        return Collections.EMPTY_LIST;
    }
}
