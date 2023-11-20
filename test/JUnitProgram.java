import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class JUnitProgram {

    PIM pim = new PIM();

    @After
    public void deletePIR(){
        String input = "1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        System.setIn(inputStream);
        pim.delete();
        System.setIn(originalIn);
    }

    @Test
    public void testCreateContactPIR() {
        // Test creating a ContactPIR
        String input = "1\nTesting Contact Topic\nTesting Name\nTM\n12345678";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.create();
            ContactPIR contactPIR = (ContactPIR) pim.pirList.get(0);
            Assert.assertEquals("Testing Contact Topic", contactPIR.topic);
            Assert.assertEquals("Testing Name", contactPIR.getName());
            Assert.assertEquals("TM", contactPIR.getAddress());
            Assert.assertEquals( "12345678", contactPIR.getMobileNo());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testCreateNotePIR() {
        // Test creating a NotePIR
        String input = "2\nTesting Note Topic\nTesting Title\nIt is just a note test";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.create();
            NotePIR notePIR = (NotePIR) pim.pirList.get(0);
            Assert.assertEquals("Testing Note Topic", notePIR.topic);
            Assert.assertEquals("Testing Title", notePIR.getTitle());
            Assert.assertEquals("It is just a note test", notePIR.getTexts());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testCreateToDoPIR() {
        // Test creating a ToDoPIR
        String input = "3\nTest Todo Topic\nTesting Todo Title\nIt is just a todo test\n21-11-2023 23-59";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.create();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            Assert.assertEquals("Test Todo Topic", toDoPIR.topic);
            Assert.assertEquals("Testing Todo Title", toDoPIR.getTitle());
            Assert.assertEquals("It is just a todo test", toDoPIR.getDescription());
            Assert.assertEquals("21-11-2023 23-59", toDoPIR.getDeadline());
        } finally {
            System.setIn(originalIn);
        }

    }

    @Test
    public void testCreateEventPIR(){
        // Test creating a EventPIR
        String input = "4\nTest Event Topic\nTesting Event Title\nIt is just a Event test\n21-11-2023\n00-00\n23-59";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.create();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals("Test Event Topic", eventPIR.topic);
            Assert.assertEquals("Testing Event Title", eventPIR.getTitle());
            Assert.assertEquals("It is just a Event test", eventPIR.getDescription());
            Assert.assertEquals("21-11-2023", eventPIR.getDate());
            Assert.assertEquals("00-00", eventPIR.getStartTime());
            Assert.assertEquals("23-59", eventPIR.getEndTime());
        } finally {
            System.setIn(originalIn);
        }

    }

    @Test
    public void testModifyContactPIR() {
        // test modifying the topic in ContactPIR
        createContactPIR();
        String input = "1\n1\nmodified contact testing topic";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.modify();
            ContactPIR contactPIR = (ContactPIR) pim.pirList.get(0);
            Assert.assertEquals("modified contact testing topic", contactPIR.topic);
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the name in ContactPIR
        input = "1\n2\nmodified contact testing name";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            ContactPIR contactPIR = (ContactPIR) pim.pirList.get(0);
            Assert.assertEquals( "modified contact testing name", contactPIR.getName());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the address in ContactPIR
        input = "1\n3\nmodified contact testing address";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            ContactPIR contactPIR = (ContactPIR) pim.pirList.get(0);
            Assert.assertEquals("modified contact testing address", contactPIR.getAddress());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Mobile Number in ContactPIR
        input = "1\n4\nmodified contact testing mobile number";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            ContactPIR contactPIR = (ContactPIR) pim.pirList.get(0);
            Assert.assertEquals("modified contact testing mobile number", contactPIR.getMobileNo());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testModifyNotePIR() {
        // test modifying the Topic in NotePIR
        createNotePIR();
        String input = "1\n1\nmodified note testing topic";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.modify();
            NotePIR notePIR = (NotePIR) pim.pirList.get(0);
            Assert.assertEquals("modified note testing topic", notePIR.topic);
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Title in NotePIR
        input = "1\n2\nmodified note testing title";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            NotePIR notePIR = (NotePIR) pim.pirList.get(0);
            Assert.assertEquals("modified note testing title", notePIR.getTitle());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Texts in NotePIR
        input = "1\n3\nmodified note testing texts";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            NotePIR notePIR = (NotePIR) pim.pirList.get(0);
            Assert.assertEquals("modified note testing texts", notePIR.getTexts());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testModifyTodoPIR() {
        // test modifying the Topic in todoPIR
        createToDoPIR();
        String input = "1\n1\nmodified todo testing topic";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.modify();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            Assert.assertEquals("modified todo testing topic", toDoPIR.topic);
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Title in todoPIR
        input = "1\n2\nmodified todo testing title";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            Assert.assertEquals( "modified todo testing title", toDoPIR.getTitle());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Description in todoPIR
        input = "1\n3\nmodified todo testing description";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            Assert.assertEquals("modified todo testing description", toDoPIR.getDescription());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Deadline in todoPIR
        input = "1\n4\n22-11-2023 23-59";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            Assert.assertEquals("22-11-2023 23-59", toDoPIR.getDeadline());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testModifyEventPIR() {
        // test modifying the Topic in EventPIR
        createEventPIR();
        String input = "1\n1\nmodified event testing topic";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.modify();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals("modified event testing topic", eventPIR.topic);
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Title in EventPIR
        input = "1\n2\nmodified event testing title";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals("modified event testing title", eventPIR.getTitle());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Description in EventPIR
        input = "1\n3\nmodified event testing Description";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals("modified event testing Description", eventPIR.getDescription());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Date in EventPIR
        input = "1\n4\n22-11-2023";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals( "22-11-2023", eventPIR.getDate());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the Start Time in EventPIR
        input = "1\n5\n12-34";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals("12-34", eventPIR.getStartTime());
        } finally {
            System.setIn(originalIn);
        }

        // test modifying the End Time in EventPIR
        input = "1\n6\n15-34";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.modify();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals("15-34", eventPIR.getEndTime());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testSearchContactPIRText(){
        // test Searching the text in ContactPIR
        createContactPIR();
        String input = "1\n12345678";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.search();
            ContactPIR contactPIR = (ContactPIR) pim.pirList.get(0);
            Assert.assertEquals("12345678", contactPIR.getMobileNo());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testSearchNotePIRText(){
        // test Searching the text in NotePIR
        createNotePIR();
        String input = "1\nTesting Note Topic";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.search();
            NotePIR notePIR = (NotePIR) pim.pirList.get(0);
            Assert.assertEquals("Testing Note Topic", notePIR.topic);
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testSearchToDoPIRText(){
        // test Searching the text in NotePIR
        createToDoPIR();
        String input = "1\nIt is just a todo test";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.search();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            Assert.assertEquals("It is just a todo test", toDoPIR.getDescription());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testSearchEventPIRText(){
        // test Searching the text in NotePIR
        createEventPIR();
        String input = "1\nTesting Event Title";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.search();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals("Testing Event Title", eventPIR.getTitle());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testSearchToDoPIRTime(){
        // test Searching the Time in TodoPIR
        // case before
        createToDoPIR();
        String input = "2\n1\n22-11-2023 0-0";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.search();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            DateHandler dateHandler = new DateHandler("22-11-2023 0-0");
            DateHandler PIRDateHandler = new DateHandler(toDoPIR.getDeadline());
            Assert.assertTrue(PIRDateHandler.before(dateHandler));
        } finally {
            System.setIn(originalIn);
        }

        // case after
        input = "2\n2\n1-1-2024 0-0";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.search();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            DateHandler dateHandler = new DateHandler("22-11-2023 0-0");
            DateHandler PIRDateHandler = new DateHandler(toDoPIR.getDeadline());
            Assert.assertFalse(PIRDateHandler.after(dateHandler));
        } finally {
            System.setIn(originalIn);
        }

        // case between
        input = "2\n3\n1-1-2024 0-0\n12-31-2024 23-59";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.search();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            DateHandler endDateHandler = new DateHandler("12-31-2024 23-59");
            DateHandler startDateHandler = new DateHandler("1-1-2024 0-0");
            DateHandler PIRDateHandler = new DateHandler(toDoPIR.getDeadline());
            Assert.assertFalse(PIRDateHandler.before(endDateHandler) && PIRDateHandler.after(startDateHandler));
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testSearchEventPIRTime(){
        // test Searching the Time in EventPIR
        // case before
        createEventPIR();
        String input = "2\n1\n20-11-2023 0-0";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.search();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            DateHandler dateHandler = new DateHandler("20-11-2023 0-0");
            DateHandler PIRDateHandler = new DateHandler(eventPIR.getDate(),eventPIR.getStartTime());
            Assert.assertFalse(PIRDateHandler.before(dateHandler));
        } finally {
            System.setIn(originalIn);
        }

        // case after
        input = "2\n2\n20-11-2023 0-0";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.search();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            DateHandler dateHandler = new DateHandler("20-11-2023 0-0");
            DateHandler PIRDateHandler = new DateHandler(eventPIR.getDate(),eventPIR.getStartTime());
            Assert.assertTrue(PIRDateHandler.after(dateHandler));
        } finally {
            System.setIn(originalIn);
        }

        // case between
        input = "2\n2\n20-11-2023 0-0\n22-11-2023 23-59";
        inputStream = new ByteArrayInputStream(input.getBytes());
        try {
            System.setIn(inputStream);
            pim.search();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            DateHandler startDateHandler = new DateHandler("20-11-2023 0-0");
            DateHandler endDateHandler = new DateHandler("22-11-2023 23-59");
            DateHandler PIRDateHandler = new DateHandler(eventPIR.getDate(),eventPIR.getStartTime());
            Assert.assertTrue(PIRDateHandler.after(startDateHandler) && PIRDateHandler.before(endDateHandler));
        } finally {
            System.setIn(originalIn);
        }
    }

    @Before
    public void testDeleteContactPIR(){
        // test deleting ContactPIR
        createContactPIR();
        String input = "1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            Assert.assertEquals(1, pim.pirList.size());
            System.setIn(inputStream);
            pim.delete();
            Assert.assertEquals(0, pim.pirList.size());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Before
    public void testDeleteNotePIR(){
        // test deleting NotePIR
        createNotePIR();
        String input = "1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            Assert.assertEquals(1, pim.pirList.size());
            System.setIn(inputStream);
            pim.delete();
            Assert.assertEquals(0, pim.pirList.size());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Before
    public void testDeleteTodoPIR(){
        // test deleting TodoPIR
        createToDoPIR();
        String input = "1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            Assert.assertEquals(1, pim.pirList.size());
            System.setIn(inputStream);
            pim.delete();
            Assert.assertEquals(0, pim.pirList.size());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Before
    public void testDeleteEventPIR(){
        // test deleting TodoPIR
        createEventPIR();
        String input = "1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            Assert.assertEquals(1, pim.pirList.size());
            System.setIn(inputStream);
            pim.delete();
            Assert.assertEquals(0, pim.pirList.size());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testPrintContactPIR(){
        // test Printing ContactPIR
        createContactPIR();
        String input = "1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.print();
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testPrintNotePIR(){
        // test Printing NotePIR
        createNotePIR();
        String input = "2\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.print();
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testPrintTodoPIR(){
        // test Printing NotePIR
        createToDoPIR();
        String input = "3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.print();
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testPrintEventPIR(){
        // test Printing NotePIR
        createEventPIR();
        String input = "4\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.print();
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testPrintAllPIR(){
        // test Printing AllPIR
        createContactPIR();
        String input = "5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.print();
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testLoadContactPIR(){
        // test Load ContactPIR
        String input = "./test/load test/A1000.pim";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.load();
            ContactPIR contactPIR = (ContactPIR) pim.pirList.get(0);
            Assert.assertEquals("Load ContactPIR Test", contactPIR.topic);
            Assert.assertEquals("Load ContactPIR Test", contactPIR.getName());
            Assert.assertEquals("Load ContactPIR Test", contactPIR.getAddress());
            Assert.assertEquals( "Load ContactPIR Test", contactPIR.getMobileNo());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testLoadNotePIR(){
        // test Load NotePIR
        String input = "./test/load test/B1001.pim";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.load();
            NotePIR notePIR = (NotePIR) pim.pirList.get(0);
            Assert.assertEquals("Load NotePIR Test", notePIR.topic);
            Assert.assertEquals("Load NotePIR Test", notePIR.getTitle());
            Assert.assertEquals("Load NotePIR Test", notePIR.getTexts());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testLoadTodoPIR(){
        // test Load TodoPIR
        String input = "./test/load test/C1002.pim";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.load();
            ToDoPIR toDoPIR = (ToDoPIR) pim.pirList.get(0);
            Assert.assertEquals("Load TodoPIR Test", toDoPIR.topic);
            Assert.assertEquals("Load TodoPIR Test", toDoPIR.getTitle());
            Assert.assertEquals("Load TodoPIR Test", toDoPIR.getDescription());
            Assert.assertEquals("21-11-2023 23-59", toDoPIR.getDeadline());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void testLoadEventPIR(){
        // test Load TodoPIR
        String input = "./test/load test/D1003.pim";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        try {
            System.setIn(inputStream);
            pim.load();
            EventPIR eventPIR = (EventPIR) pim.pirList.get(0);
            Assert.assertEquals("Load EventPIR Test", eventPIR.topic);
            Assert.assertEquals("Load EventPIR Test", eventPIR.getTitle());
            Assert.assertEquals("Load EventPIR Test", eventPIR.getDescription());
            Assert.assertEquals("21-11-2023", eventPIR.getDate());
            Assert.assertEquals("00-00", eventPIR.getStartTime());
            Assert.assertEquals("23-59", eventPIR.getEndTime());
        } finally {
            System.setIn(originalIn);
        }
    }

    private void createContactPIR(){
        String input = "1\nTesting Contact Topic\nTesting Name\nTM\n12345678";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        System.setIn(inputStream);
        pim.create();
        System.setIn(originalIn);
    }

    private void createNotePIR() {
        String input = "2\nTesting Note Topic\nTesting Title\nIt is just a note test";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        System.setIn(inputStream);
        pim.create();
        System.setIn(originalIn);
    }

    private void createToDoPIR() {
        // Test creating a ToDoPIR
        String input = "3\nTest Todo Topic\nTesting Todo Title\nIt is just a todo test\n21-11-2023 23-59";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        System.setIn(inputStream);
        pim.create();
        System.setIn(originalIn);
    }

    private void createEventPIR() {
        String input = "4\nTest Event Topic\nTesting Event Title\nIt is just a Event test\n21-11-2023\n00-00\n23-59";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputStream originalIn = System.in;
        System.setIn(inputStream);
        pim.create();
        System.setIn(originalIn);
    }


}
