package com.altairix.gwt.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;

public class LoggerAppManager implements EntryPoint {

  private final class OnButtonClick implements EventListener, RequestCallback {
    @Override
    public void handleEvent(Event evt) {
      RequestBuilder reqBldr = new RequestBuilder(RequestBuilder.POST, "/logger");
      try {
        reqBldr.sendRequest("", this);
      }
      catch (RequestException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void onError(Request request, Throwable exception) {

    }

    @Override
    public void onResponseReceived(Request request, Response response) {
    }
  }

  @Override
  public void onModuleLoad() {

    HTMLDivElement root = (HTMLDivElement) DomGlobal.document.createElement("div");
    DomGlobal.document.body.appendChild(root);

    HTMLDivElement label = (HTMLDivElement) DomGlobal.document.createElement("div");
    label.innerHTML = "Hello world!";
    root.appendChild(label);

    HTMLInputElement button = (HTMLInputElement) DomGlobal.document.createElement("input");
    button.type = "button";
    button.value = "Send Request";
    button.addEventListener("click", new OnButtonClick());
    root.appendChild(button);

  }

}