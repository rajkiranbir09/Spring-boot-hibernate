package com.project.hibernate.view.pdf;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface PdfReport<T> {
    ByteArrayInputStream getReport(List<T> list);
}