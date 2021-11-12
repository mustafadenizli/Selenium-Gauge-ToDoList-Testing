import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest{


    @Step("i write buy some milk to textbox and press enter")
    public void addToDo() {
        findElement(By.cssSelector("input[class='new-todo']")).sendKeys("buy some milk", Keys.ENTER);

    }

    @Step("Then i should see buy some milk item in  ToDo list")
    public void isDisplayItem(){
        String expectedValue = findElement(By.cssSelector("div[class='view']>label")).getText();
        Assert.assertEquals(   "buy some milk",expectedValue);

    }

    @Step("Given ToDo list with buy some milk item")
    public void listWithItem(){
        findElement(By.cssSelector("input[class='new-todo']")).sendKeys("buy some milk",Keys.ENTER);
    }

    @Step("i write enjoy the assignment to textbox and press enter")
    public void newAddToDo(){
        findElement(By.cssSelector("input[class='new-todo']")).sendKeys("enjoy the assignment",Keys.ENTER);
    }

    @Step("Then i should see enjoy the assignment item isterted to ToDo list below buy some milk item")
    public void checkNewItem(){
        String expectedValue = findElements(By.cssSelector("div[class='view']>label")).get(1).getText();
        Assert.assertEquals("enjoy the assignment",expectedValue);
    }

    @Step("i click on checkbox next to buy some milk item DONE")
    public void clickChecboxDone(){
        findElements(By.cssSelector("ul[class='todo-list']>li>div>input")).get(0).click();

    }

    @Step("Then i should see buy some milk item marked as DONE")
    public void checkDone(){
        String expectedValue = findElement(By.cssSelector("li[class='todo completed']>div>label")).getText();
        Assert.assertEquals("buy some milk",expectedValue);
    }

    @Step("i click on chexbox next to the item UNDONE")
    public void clickChecboxUnDone(){
        findElements(By.cssSelector("li[class='todo completed']>div>input")).get(0).click();
        List<WebElement> expectedValue = driver.findElements(By.cssSelector("li[class='todo']>div>label"));
        expectedValue.get(0).getText();
        Assert.assertEquals("buy some milk",expectedValue.get(0).getText());
    }

    @Step("Then i should see buy some milk item marked as UNDONE")
    public void checkAsDone(){
        String expectedValue = findElements(By.cssSelector("li[class='todo']>div>label")).get(0).getText();
        Assert.assertEquals("buy some milk",expectedValue);
    }

    @Step("Given ToDo list with rest for a while item")
    public void listeWithItem(){
        findElement(By.cssSelector("input[class='new-todo']")).sendKeys("rest for a while",Keys.ENTER);
    }

    @Step("i click on delete button next to rest for a while item")
    public void deleteItem(){
        Action(findElement(By.cssSelector("div[class='view']")));
        click(By.cssSelector("button[class='destroy']"));

    }

    @Step("Then list should be empty")
    public void checkEmptyList(){
        String isEmptyToDo = findElement(By.cssSelector("input[class='new-todo']")).getText();
        Assert.assertEquals("",isEmptyToDo);
    }

    @Step("Given ToDo list with drink water item")
    public void addItem(){
        findElement(By.cssSelector("input[class='new-todo']")).sendKeys("drink water",Keys.ENTER);
    }

    @Step("i click on delete button next to 'rest for a while' item")
    public void twoAddedandDelete(){
        Action(findElements(By.cssSelector("li[class='todo']>div>label")).get(0));
        click(By.cssSelector("button[class='destroy']"));

    }

    @Step("Then i should see drinkwater in ToDo list")
    public void checkItem(){
        String expectedValue = findElement(By.cssSelector("div[class='view']>label")).getText();
        Assert.assertEquals("drink water",expectedValue);
    }

}