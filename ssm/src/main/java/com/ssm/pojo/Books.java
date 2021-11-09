package com.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dzx
 * @date 2021/11/6 -10:44
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Books {
    private int bookID;
    private String bookName;
    private String detail;
    private int bookCounts;

}
