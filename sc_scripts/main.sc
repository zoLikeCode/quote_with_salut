require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Добро пожаловать в Цитатник, вы можете получить цитаты величайших мыслителей!

    state: ПовторитьЦитату
        q!: (повтори|озвучь) цитату
        
        script:
            $response.replies = $response.replies || []
            var body = {
                items: [{
                    command: {
                        type: "smart_app_data",
                        action: {
                            type: "repeat_quote"
                        }
                    }
                }]
            };
            $response.replies.push({ type: "raw", body: body });

    state: ОзвучиваниеЦитаты
        event!: VOICE
        if: $request.data.eventData.text
            a: {{$request.data.eventData.text}} -{{$request.data.eventData.au_text}}
        else:
            a: Не могу повторить.

    
    state: ПолучитьЦитату
        q!: (хочу|новая|выдай|подбери) (цитату|цитата)
        a: Вот цитата.

        script:
            $response.replies = $response.replies || []
            var body = {
                items: [{
                    command: {
                        type: "smart_app_data",
                        action: {
                            type: "next_quote"
                        }
                    }
                }]
            };
            $response.replies.push({ type: "raw", body: body });
        
    state: ПомощьВПриложении
        q!: помощь
        a: Вот запросы, который я знаю: "Хочу цитату", "Озвучь цитату".

        
        
    state: Fallback
        event!: noMatch
        a: Этот запрос мне не знаком. Вот команды, которые я знаю: "Помощь", "Хочу цитату", "Озвучь цитату".