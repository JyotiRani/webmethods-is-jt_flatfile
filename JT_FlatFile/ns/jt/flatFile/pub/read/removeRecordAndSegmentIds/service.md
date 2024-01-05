##### wx.util.pub.flatFile:removeRecordAndSegmentIds

This service removes the keys "@record-id", "@segment-id", "@delimiters", from the document *ffRecord*,
and/or the documents in the document list *ffRecordList*.

**File Access Control**:

This service doesn't access any entries in the file system, so no permissions for file access are
required.



**Input Parameters**:

| Name         | Description                                                  | Required / Default |
| ------------ | ------------------------------------------------------------ | ------------------ |
| ffRecord     | An optional document, from which the keys "@record-id", "@segment-id", "@delimiters" are being removed |                    |
| ffRecordList | An optional document list. For any document in the list, the keys "@record-id", "@segment-id", "@delimiters" are being removed. |                    |



**Output Parameters**

| Name         | Description                                 | Required |
| ------------ | ------------------------------------------- | -------- |
| ffRecord     | The updated input parameter *ffRecord*.     |          |
| ffRecordList | The updated input parameter *ffRecordList*. |          |



**Since**: 1.0



**Exceptions**:

IllegalArgumentException - Either of the input parameters **ffRecord**, or **ffRecordList** is invalid.



