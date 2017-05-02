<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

<c:import url="navmenu.jsp" />

<div class="container">
    <div class="col-sm-6 col-sm-offset-3">
        <h3>Contact</h3>
        <form role="form" id="contactForm" action="http://formspree.io/foodinventorytracker@gmail.com" method="post">
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="name" class="h4">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required>
                </div>
                <div class="form-group col-sm-6">
                    <label for="email" class="h4">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
                </div>
            </div>
            <div class="form-group">
                <label for="message" class="h4">Message</label>
                <textarea id="message" class="form-control" rows="5" name="message" placeholder="Enter your message" required></textarea>
            </div>
            <button type="submit" id="form-submit" class="btn btn-success btn-lg pull-right">Submit</button>
        </form>
    </div>
</div>
<br>
<br>
<c:import url="footer.jsp" />