var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

app.MapGet("/", () =>
{
    string hostname = System.Net.Dns.GetHostName();
    string html = $"<h1>C# - ServerName: {hostname}</h1>";
    return Results.Content(html, "text/html");
});

app.Run();
