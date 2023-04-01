public enum API {
    IMDB_TOP_MOVEIS("https://mocki.io/v1/dd0a4781-599c-442b-a356-98d4a1d0e42c", new ExtratorDeConteudoDoIMDB()), 
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-03-28&end_date=2023-03-31", new ExtratorDeConteudoDaNasa());

    private String url;
    private ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}
