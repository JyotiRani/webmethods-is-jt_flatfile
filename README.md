# JT_FlatFile

Tools around the processing of flat files on webMethods Integration
Server.

While the `WmFlatFile` package supports a huge variety of flat files
(incl. rather complex variants) in many cases you will simply need to
process a CSV file (comma-separated values) with the field names in
the first line of the file. The `JT_FlatFile` package supports you
here.

[![Watch the video](https://img.youtube.com/vi/74jNGZo2r3A/hqdefault.jpg)](https://youtu.be/74jNGZo2r3A)

## Services

The package comes with the following services:

- `jt.flatFile.pub.create:createDictAndSchemaFromCSV`\
  Automatically create dictionary, schema, and document type from the
  first line. You can either just copy-paste the first line or provide
  the path to a sample file.
- `jt.flatFile.pub.read:isFileCsvOrFixedLength`\
  Check if a specific separation character (usually comma or semicolon)
  appears with the first X characters of a file.
- `jt.flatFile.pub.read:removeFirstLineFromStream`\
  You typically don't want to process the first line of a CSV file (that
  is the line with the field names) with the service 
  `pub.flatFile:convertToValues`. This service allows you to skip the
  first line, assuming that LF or CR are used to indicate the end of
  lines. (So at the moment this will not work for EBCDIC encodings.)
- `jt.flatFile.pub.read:removeFirstLineFromString`\
  Like the `jt.flatFile.pub.read:removeFirstLineFromStream` service
  but for working on strings.
- `jt.flatFile.pub.read:removeRecordAndSegmentIds`\
  Remove record and segment IDs that are return by `convertToValues`.

## Examples

You can find examples in the `JT_FlatFileTest` package in this project.
Please have a look at `jt.flatFile.test.pub` folder and its
sub-folders.

## Getting Started

### Installing a Release

No releases available as of now. Instead just download from the Git
repository via the web UI or work the source code as explained in the
next section.

### Installation from Source

- Prerequisite: You need "Local Service Development" installed (located in
  Designer preferences at  "Software AG / Service Development / Local Service
  Development")
- Get sources
  - Via Software AG Designer (no separate Git installation needed)
    - Open "Java" perspective
	- Click "Import projects"
	- Select "Git / Projects from Git"
	- Select "Clone URI"
	- Paste Git URI from green "Clone or download" button above
	- Adjust target directory to `<WORKSPACE>/jt_flatfile`, which will
      then contain the main and the test package
	- Confirm defaults on all further dialogues and finish the import
  - Via command line (requires local Git installation)
    - Go into Designer workspace (e.g. `/home/john/workspace1015`)
    - Clone Git repository into new directory `git clone https://github.com/JahnTech/webmethods-is-jt_flatfile.git`
	- Import as existing projects into workspace
- Activate packages in Integration Server
	- If the "Service Development" perspective has not been active before you openend the "Java" perspective, you must quickly switch there and then directly back to "Java". This is needed to initialize the Local Service Development feature.
	- In the "Java" perspective right-click the project name and select "Move Project to IS Package"
	- Switch to the "Service Development" perspective and the packages should show up

------------------------------

These tools are provided as-is and without warranty or support. They do
not constitute part of the Software AG product suite. Users are free to
use, fork and modify them, subject to the license agreement.
While JahnTech welcomes contributions, we cannot guarantee to include every
contribution in the master project.

webMethods® is a registered trademark of Software AG and/or its subsidiaries
and/or its affiliates and/or their licensors.
