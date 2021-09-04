package servlet;
import controller.ControllerFactory;
import controller.ControllerResultDto;
import controller.Controller;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * The project starts from here.
 * Class extends of HttpServlet.
 */
@WebServlet("/Barproject/*")
public class DispatcherServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(DispatcherServlet.class);
    private ControllerFactory controllerFactory;

    /**
     * initializes HashMap from all GET/POST requests and their Controllers
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        controllerFactory = new ControllerFactory();
    }

    /**
     * Executing http request and response.
     * Executing function of redirect/forward.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = controllerFactory.getController(req);
        try {
            ControllerResultDto result = controller.execute(req, resp);
            doForwardOrRedirect(result, req, resp);
        } catch (Exception e) {
            logger.error("Cannot execute action", e);
            throw new ServletException("Cannot execute action", e);
        }
    }

    /**
     * Do redirect or forward to jsp page.
     * @param result
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void doForwardOrRedirect(ControllerResultDto result, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (result.isRedirect()) {
            resp.sendRedirect(result.getView());
        } else {
            String path = String.format("/WEB-INF/jsp/" + result.getView() + ".jsp");
            req.getRequestDispatcher(path).forward(req, resp);
        }
    }
}
